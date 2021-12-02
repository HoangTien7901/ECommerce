// Ready
    $(document).ready(function () {

      //Image loader var to use when you need a function from object
      var auctionImages = null;

      // Create image loader plugin
      var imagesloader = $('[data-type=imagesloader]').imagesloader({
        maxFiles: 8
        , minSelect: 1
        , imagesToLoad: auctionImages
      });

      //Form
      $frm = $('#frm');

      // Form submit
      $frm.submit(function (e) {

        var $form = $(this);

        var files = imagesloader.data('format.imagesloader').AttachmentArray;

        var il = imagesloader.data('format.imagesloader');

        if (il.CheckValidity())
          alert('Upload ' + files.length + ' files');        

        /*e.preventDefault();
        e.stopPropagation();*/
      });

    });

var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

try {
  fetch(new Request("https://pagead2.googlesyndication.com/pagead/js/adsbygoogle.js", { method: 'HEAD', mode: 'no-cors' })).then(function(response) {
    return true;
  }).catch(function(e) {
    var carbonScript = document.createElement("script");
    carbonScript.src = "//cdn.carbonads.com/carbon.js?serve=CK7DKKQU&placement=wwwjqueryscriptnet";
    carbonScript.id = "_carbonads_js";
    document.getElementById("carbon-block").appendChild(carbonScript);
  });
} catch (error) {
  console.log(error);
}