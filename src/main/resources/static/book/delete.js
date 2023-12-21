function deleteBookApi(judul,kode,id) {
var form = new FormData();
form.append("id", id);
form.append("judul", judul);
form.append("kode", kode);

	return $.ajax({
		url: "/api/book/delete",
		method: "PUT",
		"processData": false,
		"mimeType": "multipart/form-data",
		"contentType": false,
		"data": form,
		async: false
	});
}
	
	
	function bukaPopupHapus(judul,kode,id){
		console.log("hapus clicked") //menampilkan di console
		console.log("id"+" "+id)
		//Ganti title
		$(".modal-title").html("Delete")
		
		//Mengisi modal body
		$(".modal-body").html(
		`
		<h5> Anda ingin menghapus Buku ${judul} , ${kode} ?</h5>
		
		<button style = "position:relative; left:250px;" id = "input-cancel" class="btn btn-light">Batal</button>
		<button style = "position:relative; left:300px;" id = "input-delete" class="btn btn-danger">Hapus</button>
				
		
		
		`);
		
		$("#input-cancel").click(function(){
			$(".modal").modal("hide");
		});
		
		$("#input-delete").click(function(){
		//Ambil Response Text
		
		var responseText = deleteBookApi(judul,kode,id).responseText;
		console.log(responseText);
		
		var response = $.parseJSON(responseText);
		
			if(response.code == 200){
				alert(response.message);
				$(".modal").modal("hide");
				refreshList();
				
			}else{
				alert(response.message);
			}

	});
		
		
		//$ adalah pengenal
		// . adalah class
		// # adalah id
		$(".modal").modal("show");
	}