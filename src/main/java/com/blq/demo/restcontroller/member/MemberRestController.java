package com.blq.demo.restcontroller.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.dto.member.MemberDTO;
import com.blq.demo.services.book.BookService;
import com.blq.demo.services.member.MemberService;
import com.blq.demo.utils.Resp;

@RestController
@RequestMapping("/api/member")
public class MemberRestController {

	@Autowired
	private MemberService memberService;
	
	//get
	@GetMapping("/get")
	public Resp<List<MemberDTO>> getAll(@RequestParam("keyword") String keyword) {
		// Mengemas Response API
		int code = 200;
		String message = "Sukses";
		List<MemberDTO> data = memberService.getBook(keyword.trim());

		Resp<List<MemberDTO>> response = new Resp<>();
		response.setCode(code);
		response.setMessage(message);
		response.setData(data);

		return response;
	}



	//insert
	@PostMapping("/insert")
	public Resp<Long> insert(
			@RequestParam("nisn") String nisn,
			@RequestParam("nama") String nama,
			@RequestParam("kelas") String kelas,
			@RequestParam("no_hp") Long no_hp) {
		try {
			// Mengemas Response API
			int code = 200;
			String message = "Anggota berhasil ditambah!";
			
			memberService.addMember(nisn, nama, kelas, no_hp);
			Resp<Long> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);

			return response;
		} catch (Exception e) {
			String exceptionMessage = e.getMessage(); // "11-Blablabla"
			String[] split = exceptionMessage.split("-");

			int code = Integer.parseInt(split[0]);
			String message = split[1];

			Resp<Long> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);
			return response;
		}

	}
	
	@PutMapping("/update")
	public Resp<String> update(
			@RequestParam("id") Long id,
			@RequestParam("nisn") String nisn,
			@RequestParam("nama") String nama,
			@RequestParam("kelas") String kelas,
			@RequestParam("no_hp") Long no_hp) {
		
		try {
			// Mengemas Response API
			int code = 200;
			String message = "data berhasil diubah!";

			memberService.updateMember(id, nisn, nama, kelas, no_hp);
			
			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);

			return response;

		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage = e.getMessage(); 
			String[] split = exceptionMessage.split("-");

			int code = Integer.parseInt(split[0]);
			String message = split[1];

			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);
			return response;
		}
		
	}
	
	@PutMapping("/delete")
	public Resp<String> delete(
			@RequestParam("id") Long id) {
		
		try {
			// Mengemas Response API
			int code = 200;
			String message = "Anggota berhasil dihapus!";


			memberService.deleteMember(id);
			
			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);

			return response;

		} catch (Exception e) {
			e.printStackTrace();
			String exceptionMessage = e.getMessage(); 
			String[] split = exceptionMessage.split("-");

			int code = Integer.parseInt(split[0]);
			String message = split[1];

			Resp<String> response = new Resp<>();
			response.setCode(code);
			response.setMessage(message);
			return response;
		}
}
	
}
