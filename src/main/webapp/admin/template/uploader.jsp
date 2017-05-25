<form id="imageUpload" method="POST" action="" enctype="multipart/form-data"  class="form-horizontal form-material">
    		<div class="form-group">
    		    <label class="col-md-12">File to upload:</label>
    		    <div class="col-md-12">
    		        <input type="file" name="file">
                </div>
            </div>
            <div class="form-group">
    		    <label class="col-md-12">Name: </label>
    		    <div class="col-md-12">
    		        <input class="form-control form-control-line" type="text" name="name">
                </div>
            </div>
            <div class="form-group">
    		    <label class="col-md-12">HTML Code: </label>
    		    <div class="col-md-12">
    		        <input id="outCode" class="form-control form-control-line" type="text" name="out" disabled>
                </div>
            </div>
            <div class="form-group"><div class="col-md-12">
    		    <input class="btn btn-success" type="submit" value="Upload"> <p id="loading"></p>
    		</div></div>
    	</form>
</div>