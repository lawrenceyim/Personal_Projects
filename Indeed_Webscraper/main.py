import requests
from bs4 import BeautifulSoup
import re
import pandas


def extract_data(url):
    r = requests.get(url)
    soup = BeautifulSoup(r.content, 'html.parser')
    return soup


def transform_data(soup):
    address_regex = re.compile(r'^job_')
    # salary_regex = re.compile(r'^$(\d)+')
    divs = soup.find_all(id=address_regex)
    urls = soup.find_all('a', attrs={'href': re.compile("^/rc")})
    for i in range(0, len(urls)):
        job_title = divs[i].find('span').text.strip()
        company_title = divs[i].find('span', class_='companyName').text.strip()
        job_link = urls[i].get('href')
        # print(f"{job_title} ~~~~ {company_title} ~~~~ indeed.com{job_link}")
        job = {
            'title': job_title,
            'company': company_title,
            'link': f"indeed.com{job_link}"
        }
        job_list.append(job)


job_list = []
pages = ['https://www.indeed.com/jobs?q=software%20developer%20intern&l=Lawrenceville%2C%20GA&vjk=936f47d20e89e7b2',
        'https://www.indeed.com/jobs?q=software%20developer%20intern&l=Lawrenceville%2C%20GA&start=10&vjk=ab9d7d266d10fe47',
        'https://www.indeed.com/jobs?q=software%20developer%20intern&l=Atlanta%2C%20GA&vjk=254a1c3bc64b81c2',
        'https://www.indeed.com/jobs?q=software%20developer%20intern&l=Atlanta%2C%20GA&start=10&vjk=d722c19f5c49d36b',
        'https://www.indeed.com/jobs?q=software%20developer%20intern&l=Atlanta%2C%20GA&start=20&vjk=936f47d20e89e7b2'
]
for page in pages:
    transform_data(extract_data(page))
print(f"Number of jobs: {len(job_list)}")
for job in job_list:
    print(job)
job_results = pandas.DataFrame(job_list)
job_results.to_csv("jobs.csv")
