
 <script type="text/javascript">
$(document).ready( function() {

$('#appfoldertree').fileTree({ root: '/', script: 'jqueryFileTree.jsp', folderEvent: 'click', expandSpeed: 750, collapseSpeed: 750, multiFolder: false }, function(file) {
//alert(file);
$("#filelocation").html(file);
$("#filedownload").html("<a href='fileAction.do?action=download&location="+file+"'>Download</a>");
$("#fileupload").html("<a href='fileAction.do?action=update&location="+file+"'>Update</a>");
$("#filedelete").html("<a href='fileAction.do?action=delete&location="+file+"'>Delete</a>");
});
});
</script>
<div id="appfoldertree" ></div>

<div id="filelocation" ></div>
<div id="filedownload" ></div>
<div id="fileupload" ></div>
<div id="filedelete" ></div>

