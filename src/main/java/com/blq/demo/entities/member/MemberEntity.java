package com.blq.demo.entities.member;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.SqlResultSetMappings;
import javax.persistence.Table;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.dto.member.MemberDTO;

@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "get_member",
				query = "select id,nisn,nama,kelas,no_hp \r\n"
						+ "from member "
						+ "where nama ilike '%'|| :keyword ||'%'\r\n"
						+ "and is_delete = false \r\n"
						+ "order by nama asc",
				resultSetMapping = "get_member_result")
})

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(
		name = "get_member_result",
		classes = @ConstructorResult(
				targetClass = MemberDTO.class,
				columns = {
						@ColumnResult(name = "id",type = Long.class),
						@ColumnResult(name = "nisn",type = String.class),
						@ColumnResult(name = "nama",type = String.class),
						@ColumnResult(name = "kelas",type = String.class),
						@ColumnResult(name = "no_hp",type = Long.class),

				}))
		
})

@Entity
@Table(name = "member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	private String nisn;
	private String nama;
	private String kelas;
	private String no_hp;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean is_delete = false;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNisn() {
		return nisn;
	}
	public void setNisn(String nisn) {
		this.nisn = nisn;
	}
	public String getNama() {
		return nama;
	}
	public void setNama(String nama) {
		this.nama = nama;
	}
	public String getKelas() {
		return kelas;
	}
	public void setKelas(String kelas) {
		this.kelas = kelas;
	}
	public String getNo_hp() {
		return no_hp;
	}
	public void setNo_hp(String no_hp) {
		this.no_hp = no_hp;
	}
	
	
}
