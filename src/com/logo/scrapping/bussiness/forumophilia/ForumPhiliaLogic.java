package com.logo.scrapping.bussiness.forumophilia;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.logo.scrapping.domain.Forum;
import com.logo.scrapping.domain.Page;
import com.logo.scrapping.domain.Topic;
import com.logo.srapping.util.DocumentUtils;

public class ForumPhiliaLogic {

	private static final int TIMEOUT = 650;

	private DocumentUtils documentUtils = new DocumentUtils();

	private String url;
	private int nivelScrappping;

	/**
	 * Constructor
	 * 
	 * @param url
	 * @param nivelScrappping
	 */
	public ForumPhiliaLogic(String url, int nivelScrappping) {
		this.url = url;
		this.nivelScrappping = nivelScrappping;
	}

	/**
	 * Métodoque obtiene los foros
	 * 
	 * @param page
	 * @param tagElement
	 */
	public void obtainForum(Page page, String tagElement) {
		if (page.getNivel() <= nivelScrappping) {
			System.out.println(page);
			Document doc = documentUtils.obtainPage(page.getUrl(), TIMEOUT, true, 2);
			if (null != doc) {
				Elements links = doc.select(tagElement);
				List<Forum> forums = new ArrayList<Forum>();
				for (Element e : links) {
					Forum forum = new Forum();
					forum.setTitle(e.text());
					forum.setUrl(page.getUrl() + e.select("a[href]").attr("href"));
					obtainTopic(forum, ".topic-title");
					forums.add(forum);
				}
				page.setFormus(forums);
			}
		}
	}

	private void obtainContent(Topic topic) {
		Document doc = documentUtils.obtainPage(topic.getUrl(), TIMEOUT, true, 2);
		if (null != doc) {
			Elements links = doc.select(".postdetails");
			for (Element e : links) {
				topic.setDate(e.text());
				topic.setUrl(url + e.select("a[href]").attr("href"));
				break;
			}
			links = doc.select(".message-body");

			for (Element e : links) {
				topic.setContent(e.text());
				break;
			}
		}
	}

	private void obtainTopic(Forum forum, String tagElement) {
		if (forum.getNivel() <= nivelScrappping) {
			System.out.println(forum);
			Document doc = documentUtils.obtainPage(forum.getUrl(), TIMEOUT, true, 2);
			if (null != doc) {
				forum.setMaxPageTopic(maxPageForum(doc));
				for (int i = 0; i < forum.getMaxPageTopic(); i++) {
					if (i > 0) {
						doc = documentUtils.obtainPage(forum.getUrl().replace(".html", "-" + (i * 50) + ".html"),
								TIMEOUT, true, 2);
					}
					if (null != doc) {
						Elements links = doc.select(tagElement);
						List<Topic> topics = new ArrayList<Topic>();
						for (Element e : links) {
							if(url + e.select("a[href]").attr("href")=="https://www.forumophilia.com/topic336017.html") {
								System.out.println("s<dfasdfasfd");
							}
							Topic topic = new Topic();
							topic.setTitle(e.text());
							topic.setUrl(url + e.select("a[href]").attr("href"));
							System.out.println(topic.getUrl());
//							obtainContent(topic);
							topics.add(topic);
						}
						forum.getTopics().addAll(topics);
					}
				}
			}
		}
	}

	private int maxPageForum(Document doc) {
		int result = 0;
		Elements links = doc.select("input[name=page-number]");

		if (!links.isEmpty()) {
			for (Element e : links) {
				try {
					result = Integer.parseInt(e.attr("max"));
				} catch (Exception ex) {
					System.out.println("nose parseo");
				}
			}
		}
		return result;
	}

}
