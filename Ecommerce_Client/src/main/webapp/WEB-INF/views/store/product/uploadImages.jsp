<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!--Image Upload-->
      <div class="row mt-3 mb-2">

        <div class="col-12 pr-0 text-left">
          <label for="Images" class="col-form-label text-nowrap"><strong>Images loader</strong></label>
        </div>
      </div>

      <!--Image container -->
      <div class="row"
           data-type="imagesloader"
           data-errorformat="Accepted file formats"
           data-errorsize="Maximum size accepted"
           data-errorduplicate="File already loaded"
           data-errormaxfiles="Maximum number of images you can upload"
           data-errorminfiles="Minimum number of images to upload"
           data-modifyimagetext="Modify immage">

        <!-- Progress bar -->
        <div class="col-12 order-1 mt-2">
          <div data-type="progress" class="progress" style="height: 25px; display:none;">
            <div data-type="progressBar" class="progress-bar progress-bar-striped progress-bar-animated bg-success" role="progressbar" style="width: 100%;">Load in progress...</div>
          </div>
        </div>

        <!-- Model -->
        <div data-type="image-model" class="col-4 pl-2 pr-2 pt-2" style="max-width:200px; display:none;">

          <div class="ratio-box text-center" data-type="image-ratio-box">
            <img data-type="noimage" class="btn btn-light ratio-img img-fluid p-2 image border dashed rounded" src="/resources/stores/assets/img/photo-camera-gray.svg" style="cursor:pointer;">
            <div data-type="loading" class="img-loading" style="color:#218838; display:none;">
              <span class="fa fa-2x fa-spin fa-spinner"></span>
            </div>
            <img data-type="preview" class="btn btn-light ratio-img img-fluid p-2 image border dashed rounded" src="" style="display: none; cursor: default;">
            <span class="badge badge-pill badge-success p-2 w-50 main-tag" style="display:none;">Main</span>
          </div>

          <!-- Buttons -->
          <div data-type="image-buttons" class="row justify-content-center mt-2">
            <button data-type="add" class="btn btn-outline-success" type="button"><span class="fa fa-camera mr-2"></span>Add</button>
            <button data-type="btn-modify" type="button" class="btn btn-outline-success m-0" data-toggle="popover" data-placement="right" style="display:none;">
              <span class="fa fa-pencil-alt mr-2"></span>Modify
            </button>
          </div>
        </div>

        <!-- Popover operations -->
        <div data-type="popover-model" style="display:none">
          <div data-type="popover" class="ml-3 mr-3" style="min-width:150px;">
            <div class="row">
              <div class="col p-0">
                <button data-operation="main" class="btn btn-block btn-success btn-sm rounded-pill" type="button"><span class="fa fa-angle-double-up mr-2"></span>Main</button>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-6 p-0 pr-1">
                <button data-operation="left" class="btn btn-block btn-outline-success btn-sm rounded-pill" type="button"><span class="fa fa-angle-left mr-2"></span>Left</button>
              </div>
              <div class="col-6 p-0 pl-1">
                <button data-operation="right" class="btn btn-block btn-outline-success btn-sm rounded-pill" type="button">Right<span class="fa fa-angle-right ml-2"></span></button>
              </div>
            </div>
            <div class="row mt-2">
              <div class="col-6 p-0 pr-1">
                <button data-operation="rotateanticlockwise" class="btn btn-block btn-outline-success btn-sm rounded-pill" type="button"><span class="fas fa-undo-alt mr-2"></span>Rotate</button>
              </div>
              <div class="col-6 p-0 pl-1">
                <button data-operation="rotateclockwise" class="btn btn-block btn-outline-success btn-sm rounded-pill" type="button">Rotate<span class="fas fa-redo-alt ml-2"></span></button>
              </div>
            </div>
            <div class="row mt-2">
              <button data-operation="remove" class="btn btn-outline-danger btn-sm btn-block" type="button"><span class="fa fa-times mr-2"></span>Remove</button>
            </div>
          </div>
        </div>

      </div>

      <div class="form-group row">
        <div class="input-group">
          <!--Hidden file input for images-->
          <input id="files" type="file" name="photos" data-button="" multiple="multiple" accept="image/jpeg, image/png, image/gif," style="display:none;">
        </div>
      </div>