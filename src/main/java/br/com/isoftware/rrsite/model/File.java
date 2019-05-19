package br.com.isoftware.rrsite.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.isoftware.rrsite.model.enums.FileType;

/**
 * Created by @author olivanaires on 12/05/2019.
 */
@Entity
@Table(name = "files")
public class File extends BaseModel {

	private static final long serialVersionUID = 1L;

	private String fileName;

	@JsonIgnore
	private String fileType;
	
	@JsonIgnore
	@Enumerated(EnumType.STRING)
	private FileType type;

    @Lob
	private byte[] data;

	public File() { }

	public File(String fileName, String fileType, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.data = data;
    }
	
	public File(String fileName, String fileType, FileType type, byte[] data) {
        this.fileName = fileName;
        this.fileType = fileType;
        this.type = type;
        this.data = data;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public FileType getType() {
		return type;
	}

	public void setType(FileType type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

}
