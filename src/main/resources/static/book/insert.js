function insertBookApi(judul,kode,penerbit,pengarang,tahun){
	var form = new FormData();
	form.append("judul", judul);
	form.append("kode", kode);
	form.append("penerbit", penerbit);
	form.append("pengarang", pengarang);
	form.append("tahun", tahun);
		
		return $.ajax ({
			
		"url": "/api/book/insert",
		"method": "POST",
		"processData": false,
		"mimeType": "multipart/form-data",
		"contentType": false,
		"data": form,
		"async": false	});
	}
	
	function buttonReset(){
		//alert("reset klik");
		refreshList();
		$('#example-search-input').val('');
	}
		
	function bukaPopupAdd(){
		console.log("add  clicked") //menampilkan di console
		
		//Ganti title
		$(".modal-title").html("Tambah Data Buku")
		
		//Mengisi modal body
		$(".modal-body").html(
		`
		<table class = "table table-borderless">
			<tr>
				<td>Judul</td>
				<td>
					<input  id = "input-judul" class = "form-control">
				</td>
			</tr>
			<tr>
				<td>Kode</td>
				<td>
					<input id = "input-kode" class = "form-control">
				</td>
			</tr>
			<tr>
				<td>Penerbit</td>
				<td>
					<input id = "input-penerbit" class = "form-control">
				</td>
			</tr>
			<tr>
				<td>Pengarang</td>
				<td>
					<input id = "input-pengarang" class = "form-control">
				</td>
			</tr>
			<tr>
				<td>Tahun</td>
				<td>
					<input id = "input-tahun" class = "form-control">
				</td>
			</tr>
		
			<tr>
				<td>
				
				</td>
				<td>
					<button id ="input-cancel"  class="btn btn-danger">Batal</button>
					<button id = "input-create" class="btn btn-success">Tambah</button>
				</td>
			</tr>
			
			
		</table>
		
		
		`);
		
		$("#input-cancel").click(function(){
			$(".modal").modal("hide");
		});
		
		$("#input-create").click(function(){
			console.log("input klik")
			//ambil initial data
			var judul = $("#input-judul").val();
			var kode = $("#input-kode").val();
			var penerbit = $("#input-penerbit").val();
			var pengarang = $("#input-pengarang").val();
			var tahun = $("#input-tahun").val();
			
			//panggil api insert
			var responseText = insertBookApi(judul,kode,penerbit,pengarang,tahun).responseText;
			console.log(responseText);

			var response = $.parseJSON(responseText);
		
		if (response.code == 200) {
			alert(response.message);
			$(".modal").modal("hide");
			refreshList();
		}
			
		});
		
		//$ adalah pengenal
		// . adalah class
		// # adalah id
		$(".modal").modal("show");
	}
	