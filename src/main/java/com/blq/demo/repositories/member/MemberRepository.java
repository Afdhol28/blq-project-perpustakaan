package com.blq.demo.repositories.member;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blq.demo.dto.member.MemberDTO;
import com.blq.demo.entities.member.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long>{

		//get
		@Query(nativeQuery = true, name = "get_member")
		public List<MemberDTO> getAllMember(@Param("keyword") String keyword);
		
		//add
		@Modifying
		@Transactional
		@Query(nativeQuery = true,
				value = "insert into member \r\n"
						+ "(nisn,nama,kelas,no_hp)\r\n"
						+ "values\r\n"
						+ "(:nisn,:nama,:kelas,:no_hp)"
						)
		public void addMember(
				@Param ("nisn") String nisn,
				@Param ("nama") String nama,
				@Param ("kelas") String kelas,
				@Param ("no_hp") Long no_hp);
		
		//UPDATE DATA
				@Modifying
				@Transactional
				@Query(nativeQuery = true, value = "update member set\r\n"
						+ "nisn = :nisn,\r\n"
						+ "nama = :nama,\r\n"
						+ "kelas = :kelas,\r\n"
						+ "no_hp = :no_hp\r\n"
						+ "where id = :id")
				public void updateMember(
						@Param ("id") Long id,
						@Param ("nisn") Long nisn,
						@Param ("nama") String nama,
						@Param ("kelas") String kelas,
						@Param ("no_hp") String penerbit
						);
				
				//DELETE 
				@Modifying
				@Transactional
				@Query(nativeQuery = true, value = "update member \r\n"
						+ "set\r\n"
						+ "is_delete = true\r\n"
						+ "where id = :id")
				public void deleteMember(
						@Param ("id") Long id
						);
}
