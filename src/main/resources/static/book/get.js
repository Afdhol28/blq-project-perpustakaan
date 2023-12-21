function getBookApi() {
	return $.ajax({

		url: "/api/book/get",
		method: "GET",
		async: false
	});
}


function searchBookApi(keyword) {
	return $.ajax({

		url: "/api/book/get?keyword=" + keyword,
		method: "GET",
		async: false

	})
}

function refreshList(keyword) {

	if (keyword == null) {
		keyword = "";
	}

	var response = searchBookApi(keyword).responseJSON;
	console.log("ini json"+response);

	var list = response.data;

	$("#content-tbody").html(""); //mengosongkan sebelum menambahkan semua

	for (i = 0; i < list.length; i++) {
		$("tbody").append(
			`
			<tr> 
				<td style="text-align: center; vertical-align: middle;">${list[i].judul}</td>
				<td style="text-align: center; vertical-align: middle;">${list[i].kode}</td>
				<td style="text-align: center; vertical-align: middle;">${list[i].penerbit}</td>
				<td style="text-align: center; vertical-align: middle;">${list[i].pengarang}</td>
				<td style="text-align: center; vertical-align: middle;">${list[i].tahun}</td>
			
				<td>
				<button  class="btn btn-warning" 
				onclick="bukaPopupEdit(
					'${list[i].judul}', 
					'${list[i].kode}',
					'${list[i].penerbit}',
					'${list[i].pengarang}',
					'${list[i].tahun}',
					${list[i].id})">
					<i class="fa-regular fa-pen-to-square" color="white"></i>
					</button>
				<button  class="btn btn-danger" 
				onclick="bukaPopupHapus(
					'${list[i].judul}',
					'${list[i].kode}',
					
					${list[i].id})">
					<i class="fa-regular fa-trash-can"></i></button>
				</td>
			</tr>
				
			`
		)
	}
}


refreshList();

