package com.example.demo.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.example.demo.domain.common.DateAudit;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name = "WEBLIST")
public class WebList extends DateAudit{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;
	
	 //제목
    @Column(name = "TITLE")
    private String title;
    
    //내용
    @Column(name = "CONTENT")
    private String content;
    //링크
    @Column(name = "URL")
    private String url;
    //삭제여부
    @Column(name = "DELETE_YN",columnDefinition = "CHAR(1) default 'N'")
    private char deleteyn;
    
    //승인여부
    @Column(name = "APP_YN",columnDefinition = "CHAR(1) default 'N'")
    private char appyn;
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<WebReply> webreply;
	@OneToMany(fetch = FetchType.LAZY,orphanRemoval=true,mappedBy = "weblist")
	private List<Webfile> webfile;
    //사용자번호
    @ManyToOne(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user;
  
    	
}
