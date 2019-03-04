package com.logo.scrapping.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forum")
@XmlAccessorType(XmlAccessType.FIELD)
public class Forum implements Serializable {

	private static final long serialVersionUID = 4950399844615471396L;

	private String title;
	private String url;
	private int nivel;
	@XmlElementWrapper(name = "topics")
	@XmlElement(name = "topic")
	private List<Topic> topics = new ArrayList<Topic>();
	private int maxPageTopic;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public List<Topic> getTopics() {
		return topics;
	}

	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}

	public int getMaxPageTopic() {
		return maxPageTopic;
	}

	public void setMaxPageTopic(int maxPageTopic) {
		this.maxPageTopic = maxPageTopic;
	}

	@Override
	public String toString() {
		return "Forum [title=" + title + ", url=" + url + ", nivel=" + nivel + ", topics=" + topics + ", maxPageTopic="
				+ maxPageTopic + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxPageTopic;
		result = prime * result + nivel;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((topics == null) ? 0 : topics.hashCode());
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
		Forum other = (Forum) obj;
		if (maxPageTopic != other.maxPageTopic)
			return false;
		if (nivel != other.nivel)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (topics == null) {
			if (other.topics != null)
				return false;
		} else if (!topics.equals(other.topics))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

}
