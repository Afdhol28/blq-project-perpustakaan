package com.blq.demo.repositories.book;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blq.demo.dto.book.BookDTO;
import com.blq.demo.entities.book.BookEntity;


@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long>{

	//get
	@Query(nativeQuery = true, name = "get_book")
	public List<BookDTO> getAllBook(@Param("keyword") String keyword);
	
	//add
	@Modifying
	@Transactional
	@Query(nativeQuery = true,
			value = "insert into book (judul,kode,penerbit,pengarang,tahun)\r\n"
					+ "values\r\n"
					+ "(:judul,:kode,:penerbit,:pengarang,:tahun)"
					)
	public void addBook(
			@Param ("judul") String judul,
			@Param ("kode") String kode,
			@Param ("penerbit") String penerbit,
			@Param ("pengarang") String pengarang,
			@Param ("tahun") Long tahun);
	
	//UPDATE DATA
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update book set\r\n"
				+ "judul = :judul,\r\n"
				+ "kode = :kode,\r\n"
				+ "penerbit = :penerbit,\r\n"
				+ "pengarang = :pengarang,\r\n"
				+ "tahun = :tahun\r\n"
				+ "where id = :id")
		public void updateBook(
				@Param ("id") Long id,
				@Param ("judul") String judul,
				@Param ("kode") String kode,
				@Param ("penerbit") String penerbit,
				@Param ("pengarang") String pengarang,
				@Param ("tahun") Long tahun
				);
		
		//DELETE 
		@Modifying
		@Transactional
		@Query(nativeQuery = true, value = "update book \r\n"
				+ "set\r\n"
				+ "is_delete = true\r\n"
				+ "where id = :id")
		public void deleteBook(
				@Param ("id") Long id
				);
		
	
	@Query(nativeQuery = true, value = "select exists(select kode from book where kode=:kode)")
	public Boolean isKodeExist(
			@Param("kode") String kode); 
	
}
