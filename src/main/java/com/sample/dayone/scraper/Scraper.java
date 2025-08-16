package com.sample.dayone.scraper;

import com.sample.dayone.model.Company;
import com.sample.dayone.model.ScrapedResult;

public interface Scraper {

    Company scrapCompanyByTicker(String ticker);

    ScrapedResult scrap(Company company);
}
