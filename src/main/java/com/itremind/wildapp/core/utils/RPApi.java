package com.itremind.wildapp.core.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Created by Borisovskiy.V on 03.07.2017.
 */
public class RPApi {

    private String resultJSON;
    private String resultXML;
    private static int PRETTY_PRINT_INDENT_FACTOR = 4;


    public RPApi(String trackNumber) throws SOAPException, TransformerException {
        //Cоздаем соединение
        SOAPConnectionFactory soapConnFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection connection = soapConnFactory.createConnection();
        String url = "https://tracking.russianpost.ru/rtm34";

        //Cоздаем сообщение
        MessageFactory messageFactory = MessageFactory.newInstance("SOAP 1.2 Protocol");
        SOAPMessage message = messageFactory.createMessage();

        //Создаем объекты, представляющие различные компоненты сообщения
        SOAPPart soapPart = message.getSOAPPart();
        SOAPEnvelope envelope = soapPart.getEnvelope();
        SOAPBody body = envelope.getBody();
        envelope.addNamespaceDeclaration("soap", "http://www.w3.org/2003/05/soap-envelope");
        envelope.addNamespaceDeclaration("oper", "http://russianpost.org/operationhistory");
        envelope.addNamespaceDeclaration("data", "http://russianpost.org/operationhistory/data");
        envelope.addNamespaceDeclaration("soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        SOAPElement operElement = body.addChildElement("getOperationHistory", "oper");
        SOAPElement dataElement = operElement.addChildElement("OperationHistoryRequest", "data");
        SOAPElement barcode = dataElement.addChildElement("Barcode", "data");
        SOAPElement messageType = dataElement.addChildElement("MessageType", "data");
        SOAPElement language = dataElement.addChildElement("Language", "data");
        SOAPElement dataAuth = operElement.addChildElement("AuthorizationHeader", "data");
        SOAPFactory sf = SOAPFactory.newInstance();
        Name must = sf.createName("mustUnderstand", "soapenv", "http://schemas.xmlsoap.org/soap/envelope/");
        dataAuth.addAttribute(must, "1");
        SOAPElement login = dataAuth.addChildElement("login", "data");
        SOAPElement password = dataAuth.addChildElement("password", "data");

        //Заполняем значения
        barcode.addTextNode(trackNumber);
        messageType.addTextNode("0");
        language.addTextNode("RUS");
        login.addTextNode("ldorAbebWgixzH");
        password.addTextNode("kLA4RVVC0DMq");

        //Сохранение сообщения
        message.saveChanges();

        //Отправляем запрос и выводим ответ на экран
        SOAPMessage soapResponse = connection.call(message, url);
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.METHOD, "xml");
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        StringWriter writer = new StringWriter();
        StreamResult result = new StreamResult(writer);

        t.transform(sourceContent, result);


        resultXML = writer.toString();
        JSONObject xmlJsonObj = XML.toJSONObject(resultXML);

        JSONObject operationData = xmlJsonObj.getJSONObject("S:Envelope")
                .getJSONObject("S:Body")
                .getJSONObject("ns7:getOperationHistoryResponse")
                .getJSONObject("ns3:OperationHistoryData");
        Object historyRecord = xmlJsonObj.getJSONObject("S:Envelope")
                .getJSONObject("S:Body")
                .getJSONObject("ns7:getOperationHistoryResponse")
                .getJSONObject("ns3:OperationHistoryData")
                .get("ns3:historyRecord");
        if(historyRecord instanceof JSONObject) {
            JSONArray arr = new JSONArray();
            arr.put(historyRecord);
            operationData.remove("ns3:historyRecord");
            operationData.put("ns3:historyRecord", arr);
        }
        resultJSON = xmlJsonObj.toString(PRETTY_PRINT_INDENT_FACTOR);

        //Закрываем соединение
        connection.close();
    }

    public String getResultJSON() {
        return resultJSON;
    }

    public String getResultXML() {
        return resultXML;
    }
}
