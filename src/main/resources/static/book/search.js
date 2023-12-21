$("#button-search").click(function(){
	
	var keyword = $("#example-search-input").val();
	
	refreshList(keyword);
});

//fungsi menggunakan enter

$('#example-search-input').keypress(function(e){
  if(e.which == '13'){
    $("#button-search").click();
  }
});