package com.logo.srapping.util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class DocumentUtils {
	public Document obtainPage(String url, int timeout, boolean retry, int numbersRetries) {
		Document doc = null;
		boolean fail = false;
		int cantRetry = 0;
		do {
			try {
//				System.out.println(url);
				doc = Jsoup.connect(url).timeout(timeout).get();
				fail = false;
			} catch (IOException e) {
//				e.printStackTrace();
				fail = true;
				cantRetry++;
//				System.out.println("retry: " + retry + " ; fail: " + fail + " ; cantRetry: " + cantRetry
//						+ " ; numbersRetries: " + numbersRetries);
			}
		} while (retry && fail && (cantRetry <= numbersRetries));
		return doc;
	}
}
