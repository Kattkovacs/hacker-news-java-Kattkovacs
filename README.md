# Hacker news client

## Story

One of your best friends, Michael Hackson is really into tech news.
He prefers those aggregator sites where are no ads
just pure news with their title. So Michael can decide whether the title is catchy enough
and navigate to the concrete news, or just ignore it. This is the reason he always talks about
[Hacker news](https://news.ycombinator.com/news). Although he loves it, he imagined
some extra custom features and a more exciting design which is not so...puritan.
He knows your background and admires your programming skills so he reached out to you
to create a custom looking hacker news client exclusively for him.
As his birthday is around the corner, you take the opportunity of surprising him.

## What are you going to learn?

- what is layered architecture
- refreshing your knowledge of asyncronously fetching data from backend
- serializing data to json
- calling an API from the backend
- how to use web servlets in Java

## Tasks

1. Create a web application which renders news from `Hacker news` site
    - The opening page of the website (`/`) can accessed
    - There is a menu at the top of the page with the following elements:
- `Hackson news`
- `Top news`
- `Newest`
- `Jobs`
    - When I click on hackson news it navigates back to the start page
    - When I click on top news it refreshes the page inner content with the top news without page reload. See details below.
    - When I click on jobs it refreshes the page inner content with the jobs without page reload. See details below.
    - There is a footer with your name and email address

2. Show top news from `Hacker News` site as cards next to each other
    - There is an api endpoint `/api/top?page=1` which provides top news data in json format as follows:
```json
[
    {
    "title": "Show HN: I'm starting a Svelte JavaScript newsletter",
    "timeAgo": "a few seconds ago",
    "author": "d3sandoval",
    "url": "https://svelte.substack.com/"
    },
    ...
]
...
```
- if the page param not defiend then the first 30 elements received
- in case the page param set then the proper page of data received
  `GET /api/top?page=5` returns with the news from the 5th page
    - The opening page of the website (`/`) loads first 30 top news from hacker news
    - The page has an HTML `div` element containing the data in cards
    - Every card shows the following information of a news:
- `Title` as link to the original article
- `Author`
- `TimeAgo`
    - The webpage follows a basic design: ![Hackernews Screenshot 01](https://learn.code.cool/media/oop/hacker-news-screenshot-01.png)
    - There's a next button above the cards, clicking that shows the next 30 items of news, if any
    - There's a previous button above the cards, clicking that shows the previous 30 items of news, if any

3. When I select `Newest` from the menu the page content changes to newest news.
    - There is an api endpoint `/api/newest?page=1` which provides top news data in json format as follows:
```json
[
    {
    "title": "Show HN: I'm starting a Svelte JavaScript newsletter",
    "timeAgo": "a few seconds ago",
    "author": "d3sandoval",
    "url": "https://svelte.substack.com/"
    },
    ...
]
```
- if the page param not defiend then the first 30 elements received
- in case the page param set then the proper page of data received
  `GET /api/top?page=5` returns with the jobs from the 5th page
    - When I click on the `Newest` button in the menu the page refreshes the cards content with the first 30 items of newest news
    - The page has an HTML `div` element containing the data in cards
    - Every card shows the following information of a news:
- `Title` as link to the original article
- `Author` - the uploader if any
- `TimeAgo` - written info about when was the news published
    - There's a next button above the cards, clicking that shows the next 30 news, if any
    - There's a previous button above the vards, clicking that shows the previous 30 news, if any

4. When I select `Jobs` from the menu the page content changes to jobs related news.
    - There is an api endpoint `/api/jobs?page=1` which provides top news data in json format as follows:
```json
[
    {
        "title": "Flexport is hiring engineers in Amsterdam",
        "timeAgo": "a day ago",
        "author": "",
        "url": "https://Flexport.com"
    },
    ...
]
```
- if the page param not defiend then the first 30 elements received
- in case the page param set then the proper page of data received
  `GET /api/top?page=5` returns with the news from the 5th page
    - The page has an HTML `div` element containing the data in cards
    - Every card shows the following information of a news:
- `Title` as link to the original article
- `TimeAgo` was posted
    - There's a next button above the cards, clicking that shows the next 30 job news, if any
    - There's a previous button above the table, clicking that shows the previous 30 job news, if any

## General requirements

- For the whole project, get the data using [Hacker news API](https://api.hnpwa.com/v0) on the backend side
- The page doesn't show a server error anytime during the review
- All code is pushed to GitHub repository by atomic commits. The implemented feature related commits managed on separated feature branches and merged by a pull request to the `master` branch.

## Hints

- For examining json data you can install [JSON awesome viewer](https://chrome.google.com/webstore/detail/json-viewer-awesome/iemadiahhbebdklepanmkjenfdebfpfe?hl=en) extension for Chrome
- Whenever you have to work with APIs it is extremely useful to have [Postman](https://www.postman.com/)
- If the domain is missing from the json response it means it is an article from the hacker news itself like [this one](https://news.ycombinator.com/item?id=23574723)
- To define immutable data that globally shared and accessed across a web application use [context initialization parameters](https://www.baeldung.com/context-servlet-initialization-param#initializing-context-parameters)
- In case of serializing a list of objects [you should define the TypeToken as well](https://stackoverflow.com/a/5554296)

## Starting your project

To start your project click [this link](https://journey.code.cool/v2/project/solo/blueprint/hacker-news/java).

## Background materials

- <i class="far fa-exclamation"></i> [Introducing servlets](https://learn.code.cool/full-stack/#/../pages/java/introducing-servlets)
- <i class="far fa-exclamation"></i> [Servlets tutorial](https://www.tutorialspoint.com/servlets/servlets-form-data.htm)
- <i class="far fa-exclamation"></i> [Serialization in Java](https://learn.code.cool/full-stack/#/../pages/java/serialization-in-java)
- <i class="far fa-exclamation"></i> [Simple HTTP request in Java](https://www.baeldung.com/java-http-request)
- <i class="far fa-exclamation"></i> [Returning a JSON response from a servlet](https://www.baeldung.com/servlet-json-response)
- <i class="far fa-exclamation"></i> [Custom Gson serialization](https://futurestud.io/tutorials/gson-advanced-custom-serialization-part-1)
- <i class="far fa-open_book"></i> [Retreiving data from the backend](https://learn.code.cool/full-stack/#/../pages/web/the-last-missing-piece-api)
- <i class="far fa-open_book"></i> [Do you remember of REST?](https://learn.code.cool/full-stack/#/../pages/web/restful)
- <i class="far fa-open_book"></i> [Layered architecture](https://medium.com/@priyalwalpita/software-architecture-patterns-layered-architecture-a3b89b71a057)
