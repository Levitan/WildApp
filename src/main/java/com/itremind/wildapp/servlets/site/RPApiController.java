package com.itremind.wildapp.servlets.site;

import com.itremind.wildapp.core.utils.RPApi;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.xml.soap.SOAPException;
import javax.xml.transform.TransformerException;

/**
 * Created by Borisovskiy.V on 03.07.2017.
 */
@Controller
public class RPApiController {

    @RequestMapping(value = "/apiJson", method = RequestMethod.GET)
    public String showJSON(@RequestParam("track") String trackNumber, Model model){
        String jsonResult = "";
        try {
            jsonResult = new RPApi(trackNumber).getResultJSON();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        model.addAttribute("JSON", jsonResult);
        return "/site/apijson";
    }

    @RequestMapping(value = "/apiXML", method = RequestMethod.GET)
    public String showXML(@RequestParam("track") String trackNumber, Model model){
        String xmlResult = "";
        try {
            xmlResult = new RPApi(trackNumber).getResultXML();
        } catch (SOAPException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        model.addAttribute("XML", xmlResult);
        return "/site/apixml";
    }
    @RequestMapping(value = "/api", method = RequestMethod.GET)
    public String debugApi(Model model){
        String json = "{\"S:Envelope\": {\n" +
                "    \"xmlns:S\": \"http://www.w3.org/2003/05/soap-envelope\",\n" +
                "    \"S:Body\": {\"ns7:getOperationHistoryResponse\": {\n" +
                "        \"xmlns:ns2\": \"http://russianpost.org/sms-info/data\",\n" +
                "        \"xmlns:ns5\": \"http://www.russianpost.org/custom-duty-info/data\",\n" +
                "        \"xmlns:ns6\": \"http://www.russianpost.org/RTM/DataExchangeESPP/Data\",\n" +
                "        \"xmlns:ns3\": \"http://russianpost.org/operationhistory/data\",\n" +
                "        \"ns3:OperationHistoryData\": {\"ns3:historyRecord\": [\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:ComplexItemName\": \"Письмо заказное\",\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 2,\n" +
                "                        \"ns3:Name\": \"Письмо\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\"ns3:Id\": 0},\n" +
                "                    \"ns3:OperDate\": \"2017-06-20T12:30:00.000+01:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 10,\n" +
                "                        \"ns3:Name\": \"Экспорт международной почты\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:Rcpn\": \"\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"МР ЛЦ Внуково Цех-1\",\n" +
                "                        \"ns3:Index\": 102976\n" +
                "                    },\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:DestinationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов 10\",\n" +
                "                        \"ns3:Index\": 410010\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:PostMark\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без отметки\"\n" +
                "                    },\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Internum\": \"RE218699711SE\",\n" +
                "                    \"ns3:ComplexItemName\": \"Мелкий пакет заказной\",\n" +
                "                    \"ns3:Mass\": 128,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 5,\n" +
                "                        \"ns3:Name\": \"Мелкий пакет\"\n" +
                "                    },\n" +
                "                    \"ns3:MailRank\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без разряда\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 13,\n" +
                "                        \"ns3:Name\": \"Прибыло на территорию РФ\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-06-30T02:26:16.000+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:SendCtg\": {\n" +
                "                        \"ns3:Id\": 4,\n" +
                "                        \"ns3:Name\": \"Международный оператор\"\n" +
                "                    },\n" +
                "                    \"ns3:Rcpn\": \"Borisovskiy Vitaliy Yurevich\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"МР ЛЦ Внуково Цех-1\",\n" +
                "                        \"ns3:Index\": 102976\n" +
                "                    },\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:DestinationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов 10\",\n" +
                "                        \"ns3:Index\": 410010\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:PostMark\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без отметки\"\n" +
                "                    },\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Internum\": \"RE218699711SE\",\n" +
                "                    \"ns3:ComplexItemName\": \"Мелкий пакет заказной\",\n" +
                "                    \"ns3:Mass\": 128,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 5,\n" +
                "                        \"ns3:Name\": \"Мелкий пакет\"\n" +
                "                    },\n" +
                "                    \"ns3:MailRank\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без разряда\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\"ns3:Id\": 0},\n" +
                "                    \"ns3:OperDate\": \"2017-06-30T03:52:08.000+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 9,\n" +
                "                        \"ns3:Name\": \"Импорт международной почты\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:SendCtg\": {\n" +
                "                        \"ns3:Id\": 4,\n" +
                "                        \"ns3:Name\": \"Международный оператор\"\n" +
                "                    },\n" +
                "                    \"ns3:Rcpn\": \"Borisovskiy Vitaliy Yurevich\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"МР ЛЦ Внуково Цех-1\",\n" +
                "                        \"ns3:Index\": 102976\n" +
                "                    },\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:DestinationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов 10\",\n" +
                "                        \"ns3:Index\": 410010\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:PostMark\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без отметки\"\n" +
                "                    },\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Internum\": \"RE218699711SE\",\n" +
                "                    \"ns3:ComplexItemName\": \"Мелкий пакет заказной\",\n" +
                "                    \"ns3:Mass\": 128,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 5,\n" +
                "                        \"ns3:Name\": \"Мелкий пакет\"\n" +
                "                    },\n" +
                "                    \"ns3:MailRank\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без разряда\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\"ns3:Id\": 1},\n" +
                "                    \"ns3:OperDate\": \"2017-06-30T05:20:20.000+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 11,\n" +
                "                        \"ns3:Name\": \"Прием на таможню\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:SendCtg\": {\"ns3:Id\": 0},\n" +
                "                    \"ns3:Rcpn\": \"Borisovskiy Vitaliy Yurevich\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\n" +
                "                    \"ns3:InsrRate\": 0,\n" +
                "                    \"ns3:Rate\": 0,\n" +
                "                    \"ns3:MassRate\": 0,\n" +
                "                    \"ns3:CustomDuty\": 0,\n" +
                "                    \"ns3:AirRate\": 0,\n" +
                "                    \"ns3:Payment\": 0,\n" +
                "                    \"ns3:Value\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"МР ЛЦ Внуково Цех-1\",\n" +
                "                        \"ns3:Index\": 102976\n" +
                "                    },\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:DestinationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов 10\",\n" +
                "                        \"ns3:Index\": 410010\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:PostMark\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без отметки\"\n" +
                "                    },\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Internum\": \"RE218699711SE\",\n" +
                "                    \"ns3:ComplexItemName\": \"Мелкий пакет заказной\",\n" +
                "                    \"ns3:Mass\": 128,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 5,\n" +
                "                        \"ns3:Name\": \"Мелкий пакет\"\n" +
                "                    },\n" +
                "                    \"ns3:MailRank\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без разряда\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Выпущено таможней\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-06-30T05:21:20.000+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 14,\n" +
                "                        \"ns3:Name\": \"Таможенное оформление\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:SendCtg\": {\"ns3:Id\": 0},\n" +
                "                    \"ns3:Rcpn\": \"Borisovskiy Vitaliy Yurevich\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\n" +
                "                    \"ns3:InsrRate\": 0,\n" +
                "                    \"ns3:Rate\": 0,\n" +
                "                    \"ns3:MassRate\": 0,\n" +
                "                    \"ns3:CustomDuty\": 0,\n" +
                "                    \"ns3:AirRate\": 0,\n" +
                "                    \"ns3:Payment\": 0,\n" +
                "                    \"ns3:Value\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"МР ЛЦ Внуково Цех-1\",\n" +
                "                        \"ns3:Index\": 102976\n" +
                "                    },\n" +
                "                    \"ns3:CountryFrom\": {\n" +
                "                        \"ns3:NameEN\": \"Sweden\",\n" +
                "                        \"ns3:Id\": 752,\n" +
                "                        \"ns3:Code3A\": \"SWE\",\n" +
                "                        \"ns3:Code2A\": \"SE\",\n" +
                "                        \"ns3:NameRU\": \"Швеция\"\n" +
                "                    },\n" +
                "                    \"ns3:MailDirect\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    },\n" +
                "                    \"ns3:DestinationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов 10\",\n" +
                "                        \"ns3:Index\": 410010\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:PostMark\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без отметки\"\n" +
                "                    },\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Internum\": \"RE218699711SE\",\n" +
                "                    \"ns3:ComplexItemName\": \"Мелкий пакет заказной\",\n" +
                "                    \"ns3:Mass\": 0,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false,\n" +
                "                    \"ns3:MailCtg\": {\n" +
                "                        \"ns3:Id\": 1,\n" +
                "                        \"ns3:Name\": \"Заказное\"\n" +
                "                    },\n" +
                "                    \"ns3:MailType\": {\n" +
                "                        \"ns3:Id\": 5,\n" +
                "                        \"ns3:Name\": \"Мелкий пакет\"\n" +
                "                    },\n" +
                "                    \"ns3:MailRank\": {\n" +
                "                        \"ns3:Id\": 0,\n" +
                "                        \"ns3:Name\": \"Без разряда\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 6,\n" +
                "                        \"ns3:Name\": \"Покинуло место международного обмена\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-07-01T12:58:08.000+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:SendCtg\": {\"ns3:Id\": 0},\n" +
                "                    \"ns3:Rcpn\": \"Borisovskiy Vitaliy Yurevich\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\n" +
                "                    \"ns3:InsrRate\": 0,\n" +
                "                    \"ns3:Rate\": 0,\n" +
                "                    \"ns3:MassRate\": 0,\n" +
                "                    \"ns3:CustomDuty\": 0,\n" +
                "                    \"ns3:AirRate\": 0,\n" +
                "                    \"ns3:Payment\": 0,\n" +
                "                    \"ns3:Value\": 0\n" +
                "                }\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"Пенза МСЦ\",\n" +
                "                        \"ns3:Index\": 440960\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 3,\n" +
                "                        \"ns3:Name\": \"Прибыло в сортировочный центр\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-07-02T02:59:24.001+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:Rcpn\": \"\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"Пенза МСЦ\",\n" +
                "                        \"ns3:Index\": 440960\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 4,\n" +
                "                        \"ns3:Name\": \"Покинуло сортировочный центр\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-07-02T03:01:17.001+03:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:Rcpn\": \"\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов МСЦ\",\n" +
                "                        \"ns3:Index\": 410960\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 3,\n" +
                "                        \"ns3:Name\": \"Прибыло в сортировочный центр\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-07-02T08:51:42.001+04:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:Rcpn\": \"\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            },\n" +
                "            {\n" +
                "                \"ns3:AddressParameters\": {\n" +
                "                    \"ns3:OperationAddress\": {\n" +
                "                        \"ns3:Description\": \"Саратов МСЦ\",\n" +
                "                        \"ns3:Index\": 410960\n" +
                "                    },\n" +
                "                    \"ns3:CountryOper\": {\n" +
                "                        \"ns3:NameEN\": \"Russian Federation\",\n" +
                "                        \"ns3:Id\": 643,\n" +
                "                        \"ns3:Code3A\": \"RUS\",\n" +
                "                        \"ns3:Code2A\": \"RU\",\n" +
                "                        \"ns3:NameRU\": \"Российская Федерация\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:ItemParameters\": {\n" +
                "                    \"ns3:ValidRuType\": false,\n" +
                "                    \"ns3:Barcode\": \"RE218699711SE\",\n" +
                "                    \"ns3:ValidEnType\": false\n" +
                "                },\n" +
                "                \"ns3:OperationParameters\": {\n" +
                "                    \"ns3:OperAttr\": {\n" +
                "                        \"ns3:Id\": 4,\n" +
                "                        \"ns3:Name\": \"Покинуло сортировочный центр\"\n" +
                "                    },\n" +
                "                    \"ns3:OperDate\": \"2017-07-03T03:32:10.001+04:00\",\n" +
                "                    \"ns3:OperType\": {\n" +
                "                        \"ns3:Id\": 8,\n" +
                "                        \"ns3:Name\": \"Обработка\"\n" +
                "                    }\n" +
                "                },\n" +
                "                \"ns3:UserParameters\": {\n" +
                "                    \"ns3:Rcpn\": \"\",\n" +
                "                    \"ns3:Sndr\": \"\"\n" +
                "                },\n" +
                "                \"ns3:FinanceParameters\": {\"ns3:CustomDuty\": 0}\n" +
                "            }\n" +
                "        ]},\n" +
                "        \"xmlns:ns4\": \"http://schemas.xmlsoap.org/soap/envelope/\",\n" +
                "        \"xmlns:ns7\": \"http://russianpost.org/operationhistory\"\n" +
                "    }}\n" +
                "}}";

        JSONObject jObj = new JSONObject(json);
        JSONObject operationData = jObj.getJSONObject("S:Envelope")
                .getJSONObject("S:Body")
                .getJSONObject("ns7:getOperationHistoryResponse")
                .getJSONObject("ns3:OperationHistoryData");
        Object historyRecord = jObj.getJSONObject("S:Envelope")
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
        String jsonResult = jObj.toString();
        model.addAttribute("JSON", jsonResult);
        return "/site/apijson";
    }
}
