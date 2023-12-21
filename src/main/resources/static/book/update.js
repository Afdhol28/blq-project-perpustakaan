function updateBookApi(id,judul, kode,penerbit,pengarang,tahun) {
	var formData = new FormData();
	formData.append("id", id);
	formData.append("judul", judul);
	formData.append("kode", kode);
	formData.append("penerbit", penerbit);
	formData.append("pengarang", pengarang);
	formData.append("tahun", tahun);
	
	return $.ajax({

		"url": "/api/book/update",
		"method": "PUT",
		"processData": false,
		"mimeType": "multipart/form-data",
		"contentType": false,
		"data": formData,
		async: false  //agar tdk kemana mana
	});
}

function bukaPopupEdit(judul, kode, penerbit, pengarang,tahun,id) {
	console.log("edit clicked") //menampilkan di console
	//console.log( + " " + pengarang + " " + tahun)

	//Ganti title
	$(".modal-title").html("Edit")

	//Mengisi modal body
	$(".modal-body").html(
		`
		<table class = "table table-borderless">
			<tr>
				<td>Judul</td>
				<td>
					<input id="input-judul" class = "form-control" value="${judul}">
				</td>
			</tr>
			<tr>
				<td>Kode</td>
				<td>
					<input id = "input-kode" class = "form-control" value="${kode}">
				</td>
			</tr>
			<tr>
				<td>Penerbit</td>
				<td>
					<input id = "input-penerbit" class = "form-control" value="${penerbit}">
				</td>
			</tr>
			<tr>
				<td>Pengarang</td>
				<td>
					<input id = "input-pengarang" class = "form-control" value="${pengarang}">
				</td>
			</tr>
			<tr>
				<td>Tahun</td>
				<td>
					<input id = "input-tahun" class = "form-control" value="${tahun}">
				</td>
			</tr>
			<tr>
				<td>
				</td>
				<td>
					<button id = "input-cancel" class="btn btn-danger">Batal</button>
					<button id = "input-update" class="btn btn-warning">Simpan Perubahan</button>
				</td>
			</tr>
			
			
		</table>
		
		
		`);

	$("#input-cancel").click(function() {
		$(".modal").modal("hide");
	});

	$("#input-update").click(function() {
			var judul = $("#input-judul").val();
			console.log("judul: " + judul);
			var kode = $("#input-kode").val();
			console.log("kode: " + kode);
			var penerbit = $("#input-penerbit").val();
			console.log("penerbit: " + penerbit);
			var pengarang = $("#input-pengarang").val();
			console.log("pengarang: " + pengarang);
			var tahun = $("#input-tahun").val();
			console.log("tahun: " + tahun);

		//Panggil API 
		var response = updateBookApi(id,judul,kode,penerbit,pengarang,tahun).responseText;

		var responseJson = $.parseJSON(response);

		
		if (responseJson.code == 200) {
			alert(responseJson.message);
			$(".modal").modal("hide");
			refreshList();

		} else {
			alert(responseJson.message);
		}


	});



	//$ adalah pengenal
	// . adalah class
	// # adalah id
	$(".modal").modal("show");
}
