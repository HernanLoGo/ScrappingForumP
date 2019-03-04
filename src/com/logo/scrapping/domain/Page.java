package com.logo.scrapping.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "page")
@XmlAccessorType(XmlAccessType.FIELD)
public class Page implements Serializable {

	private static final long serialVersionUID = -2224019073232591668L;

	String name;
	String url;
	
	@XmlElementWrapper(name="forums")
    @XmlElement(name="forum")
	List<Forum> formus = new ArrayList<Forum>();
	int nivel;

	public String getName() {
		return name;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Forum> getFormus() {
		return formus;
	}

	public void setFormus(List<Forum> formus) {
		this.formus = formus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((formus == null) ? 0 : formus.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + nivel;
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Page other = (Page) obj;
		if (formus == null) {
			if (other.formus != null)
				return false;
		} else if (!formus.equals(other.formus))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nivel != other.nivel)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Page [name=" + name + ", url=" + url + ", formus=" + formus + ", nivel=" + nivel + "]";
	}

}
