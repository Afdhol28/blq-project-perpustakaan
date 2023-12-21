package com.blq.demo.services.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.dto.member.MemberDTO;
import com.blq.demo.repositories.member.MemberRepository;

@Service
public class MemberService {

	@Autowired
	private MemberRepository memberRepository;
	
		//get	
		public List<MemberDTO> getBook(String keyword) {

			return memberRepository.getAllMember(keyword);
		}
		
		//add
		public void addMember(String nisn, String nama, String kelas, Long no_hp) throws Exception {

			memberRepository.addMember(nisn, nama, kelas, no_hp);
				
		}
		
		//update
		public void updateMember(Long id,String nisn, String nama, String kelas, Long no_hp) {
					
			memberRepository.updateMember(id, no_hp, nama, kelas, kelas);
		}
		
		//delete
			public void deleteMember(Long id) {

				memberRepository.deleteMember(id);
				
			}
}
