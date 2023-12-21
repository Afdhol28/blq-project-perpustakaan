package com.blq.demo.dto.book;

public class BookDTO {

	private Long id;
	private String kode;
	private String judul;
	private String pengarang;
	private Integer tahun;
	private String penerbit;
	
	
	public BookDTO(Long id, String kode, String judul, String pengarang, Integer tahun, String penerbit) {
		super();
		this.id = id;
		this.kode = kode;
		this.judul = judul;
		this.pengarang = pengarang;
		this.tahun = tahun;
		this.penerbit = penerbit;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	public String getKode() {
		return kode;
	}


	public void setKode(String kode) {
		this.kode = kode;
	}


	public String getJudul() {
		return judul;
	}


	public void setJudul(String judul) {
		this.judul = judul;
	}


	public String getPengarang() {
		return pengarang;
	}


	public void setPengarang(String pengarang) {
		this.pengarang = pengarang;
	}


	public Integer getTahun() {
		return tahun;
	}


	public void setTahun(Integer tahun) {
		this.tahun = tahun;
	}


	public String getPenerbit() {
		return penerbit;
	}


	public void setPenerbit(String penerbit) {
		this.penerbit = penerbit;
	}
	
	
	
	
}
