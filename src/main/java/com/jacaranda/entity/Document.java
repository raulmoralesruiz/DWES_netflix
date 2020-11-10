package com.jacaranda.entity;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Document {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idDocument;
	private Blob file;
	private String fileName;	
	private Integer fileSize;
	/* fecha, tamaño, formato, host */
	
	
	  
	public Document() {
		super();
	}
	public Document(Blob file, String fileName, Integer fileSize) {
		super();
		this.file = file;
		this.fileName = fileName;
		this.fileSize = fileSize;
	}
	
	
	
	public Long getIdDocument() {
		return idDocument;
	}
	public void setIdDocument(Long idDocument) {
		this.idDocument = idDocument;
	}
	public Blob getFile() {
		return file;
	}
	public void setFile(Blob file) {
		this.file = file;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getFileSize() {
		return fileSize;
	}
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	
	
	

}
