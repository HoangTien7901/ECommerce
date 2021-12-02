<!DOCTYPE html>
<!--  main-fragment (title, otherStaticResources, header, nav, mainContent, footer)  -->
<html xmlns:th="http://www.thymeleaf.org"
      th:replace="~{templates/stores/layouts/main-layout :: main-fragment(  
                                                ~{::title},
                                                ~{:: #home-static-resources},
                                                ~{:: #home-header},
                                                ~{:: #home-nav},
                                                ~{:: #home-main-content},  
                                                ~{:: #home-footer}
                                               )}">
                                              
<head>
    <title>Title of Home Page</title>
    <th:block id="home-static-resources">
        <!-- <script type="text/javascript" src="static/stores/home.js" th:src="@{/home.js}"></script> -->
        <link rel="stylesheet" type="text/css" href="/resources/static/stores/main.css" th:href="@{/main.css}"/>
    </th:block>
</head>
<body>
    <div id="home-header">
        Header of Home Page
    </div>
    <div id="home-nav" th:replace="~{/fragments/app-fragments :: nav-default}">
        Home Nav
    </div>
    <div id="home-main-content">
        <h2>Home content</h2>
        <div>Content of Home Page</div>
    </div>
    <div id="home-footer" th:replace="~{/fragments/app-fragments :: copyright}">
        Footer
    </div>
</body>
</html>