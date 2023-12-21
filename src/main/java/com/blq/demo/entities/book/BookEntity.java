package com.blq.demo.entities.book;

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



@NamedNativeQueries(value = {
		@NamedNativeQuery(name = "get_book",
				query = "select id,judul,kode,penerbit,pengarang,tahun \r\n"
						+ "from book "
						+ "where judul ilike '%'|| :keyword ||'%'\r\n"
						+ "and is_delete = false \r\n"
						+ "order by judul asc",
				resultSetMapping = "get_book_result")
})

@SqlResultSetMappings(value = {
		@SqlResultSetMapping(
		name = "get_book_result",
		classes = @ConstructorResult(
				targetClass = BookDTO.class,
				columns = {
						@ColumnResult(name = "id",type = Long.class),
						@ColumnResult(name = "kode",type = String.class),
						@ColumnResult(name = "judul",type = String.class),
						@ColumnResult(name = "pengarang",type = String.class),
						@ColumnResult(name = "tahun",type = Integer.class),
						@ColumnResult(name = "penerbit",type = String.class),

				}))
		
})

@Entity
@Table(name = "book")
public class BookEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private Long id;
	private String kode;
	private String judul;
	private String pengarang;
	private Integer tahun;
	private String penerbit;
	@Column(nullable = false, columnDefinition = "boolean default false")
	private Boolean is_delete = false;
	
	
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
	public boolean isIs_delete() {
		return is_delete;
	}
	public void setIs_delete(boolean is_delete) {
		this.is_delete = is_delete;
	}
	
	

}
