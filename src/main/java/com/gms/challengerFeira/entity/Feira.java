package com.gms.challengerFeira.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Feira {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", unique = true)
	private Integer id;
	@Column(name = "LONGI")
	private String longi;
	@Column(name = "LAT")
	private String lat;
	@Column(name = "SETCENS")
	private String setcens;
	@Column(name = "AREAP")
	private String areaP;
	@Column(name = "CODDIST")
	private String codDist;
	@Column(name = "DISTRITO")
	private String distrito;
	@Column(name = "CODSUBPREF")
	private String codSubPref;
	@Column(name = "SUBPREFE")
	private String subPrefe;
	@Column(name = "REGIAO5")
	private String regiao5;
	@Column(name = "REGIAO8")
	private String regiao8;
	@Column(name = "NOME_FEIRA")
	private String nomeFeira;
	@Column(name = "REGISTRO")
	private String registro;
	@Column(name = "LOGRADOURO")
	private String logradouro;
	@Column(name = "NUMERO")
	private String numero;
	@Column(name = "BAIRRO")
	private String bairro;
	@Column(name = "REFERENCIA")
	private String referencia;

	public Feira(String longi, String lat, String setcens, String areaP, String codDist, String distrito,
			String codSubPref, String subPrefe, String regiao5, String regiao8, String nomeFeira, String registro,
			String logradouro, String numero, String bairro, String referencia) {

		this.longi = longi;
		this.lat = lat;
		this.setcens = setcens;
		this.areaP = areaP;
		this.codDist = codDist;
		this.distrito = distrito;
		this.codSubPref = codSubPref;
		this.subPrefe = subPrefe;
		this.regiao5 = regiao5;
		this.regiao8 = regiao8;
		this.nomeFeira = nomeFeira;
		this.registro = registro;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.referencia = referencia;
	}

	public Feira() {

	}

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

	

}
