package com.blq.demo.dto.member;

public class MemberDTO {

	private Long id;
	private String nisn;
	private String nama;
	private String kelas;
	private Long no_hp;
	
	
	public MemberDTO(Long id, String nisn, String nama, String kelas, Long no_hp) {
		super();
		this.id = id;
		this.nisn = nisn;
		this.nama = nama;
		this.kelas = kelas;
		this.no_hp = no_hp;
	}
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
	public Long getNo_hp() {
		return no_hp;
	}
	public void setNo_hp(Long no_hp) {
		this.no_hp = no_hp;
	}
	
	
}
