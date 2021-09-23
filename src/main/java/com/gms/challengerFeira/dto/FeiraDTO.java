package com.gms.challengerFeira.dto;



import java.util.List;
import java.util.stream.Collectors;

import com.gms.challengerFeira.entity.Feira;


public class FeiraDTO {
	
	private Integer id;
	private String longi;
	private String lat;
	private String setcens;
	private String areaP;
	private String codDist;
	private String distrito;
	private String codSubPref;
	private String subPrefe;
	private String regiao5;
	private String regiao8;
	private String nomeFeira;
	private String registro;
	private String logradouro;
	private String numero;
	private String bairro;
	private String referencia;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLongi() {
		return longi;
	}
	public void setLongi(String longi) {
		this.longi = longi;
	}
	public String getLat() {
		return lat;
	}
	public void setLat(String lat) {
		this.lat = lat;
	}
	public String getSetcens() {
		return setcens;
	}
	public void setSetcens(String setcens) {
		this.setcens = setcens;
	}
	public String getAreaP() {
		return areaP;
	}
	public void setAreaP(String areaP) {
		this.areaP = areaP;
	}
	public String getCodDist() {
		return codDist;
	}
	public void setCodDist(String codDist) {
		this.codDist = codDist;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	public String getCodSubPref() {
		return codSubPref;
	}
	public void setCodSubPref(String codSubPref) {
		this.codSubPref = codSubPref;
	}
	public String getSubPrefe() {
		return subPrefe;
	}
	public void setSubPrefe(String subPrefe) {
		this.subPrefe = subPrefe;
	}
	public String getRegiao5() {
		return regiao5;
	}
	public void setRegiao5(String regiao5) {
		this.regiao5 = regiao5;
	}
	public String getRegiao8() {
		return regiao8;
	}
	public void setRegiao8(String regiao8) {
		this.regiao8 = regiao8;
	}
	public String getNomeFeira() {
		return nomeFeira;
	}
	public void setNomeFeira(String nomeFeira) {
		this.nomeFeira = nomeFeira;
	}
	public String getRegistro() {
		return registro;
	}
	public void setRegistro(String registro) {
		this.registro = registro;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getReferencia() {
		return referencia;
	}
	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}
	
	public FeiraDTO(Feira feira) {
		this.id = feira.getId();
		this.longi = feira.getLongi();
		this.lat = feira.getLat();
		this.setcens = feira.getSetcens();
		this.areaP = feira.getAreaP();
		this.codDist = feira.getCodDist();
		this.distrito = feira.getDistrito();
		this.codSubPref = feira.getCodSubPref();
		this.subPrefe = feira.getSubPrefe();
		this.regiao5 = feira.getRegiao5();
		this.regiao8 = feira.getRegiao8();
		this.nomeFeira = feira.getNomeFeira();
		this.registro = feira.getRegistro();
		this.logradouro = feira.getLogradouro();
		this.numero = feira.getNumero();
		this.bairro = feira.getBairro();
		this.referencia = feira.getReferencia();
		
	}
	
	public static List<FeiraDTO> converter(List<Feira> feiras) {
		return feiras.stream().map(FeiraDTO::new).collect(Collectors.toList()); 
	}

}
