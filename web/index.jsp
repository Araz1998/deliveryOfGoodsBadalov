<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.araz.entity.User" %>
<%--
  Created by IntelliJ IDEA.
  User: Araz
  Date: 27.01.2021
  Time: 0:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="utf-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/fmt" prefix = "fmt" %>
<fmt:setLocale value="${lang}"/>
<fmt:setBundle basename="messages"/>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Main Page</title>
    <link rel="stylesheet" href="/view/css/header.css">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css ">

    <link rel="stylesheet" href="//unpkg.com/bootstrap-select@1.12.4/dist/css/bootstrap-select.min.css" type="text/css" />
  </head>
  <body>

  <%@include file="view/blocks/header.jsp"%>
  <%
      if (session != null) {
          if (session.getAttribute("user") != null) {
              User user = (User) session.getAttribute("user");
              out.print("Hello, " + user.getLogin() + "  Welcome to ur Profile " + user.getId());
          } else {
              out.println("NULL!");
          }
      }
  %>
  <style>
    /* Make the image fully responsive */
    .carousel-inner img {
      width: 80%;
      height: 70%;
    }
  </style>
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
    <ol class="carousel-indicators">
      <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
      <li data-target="#carouselExampleCaptions" data-slide-to="2"></li>
    </ol>
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="view/blocks/2.jpg" class="d-block w-100" alt="EXIST" >
        <div class="carousel-caption d-none d-md-block">
          <h5>Send anywhere in the world</h5>
          <p>Send anywhere in the world</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="view/blocks/3.jpg" class="d-block w-100" alt="..." width="1100" height="500">
        <div class="carousel-caption d-none d-md-block">
          <h5>Second slide label</h5>
          <p>use modern technology</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="view/blocks/cars.jpg" class="d-block w-100" alt="..." width="930" height="500">
        <div class="carousel-caption d-none d-md-block">
          <h5>Third slide label</h5>
          <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>

  <div class="row">
    <div class="col-sm-4">
      <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-body">
          <h5 class="card-title">Special title treatment</h5>
          <img src="https://cdn2.iconfinder.com/data/icons/vehicle-type/1024/mini-suv-512.png" class="d-block w-25" alt="EXIST" >

          <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
          <button type="button" class="btn btn-primary d-block mx-auto" disabled> Light </button>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-body">
          <h5 class="card-title">Special title treatment</h5>
            <img src="https://cdn2.iconfinder.com/data/icons/transportation-solid-7/64/transportation-vehicle-25-512.png" class="d-block w-25" alt="EXIST" >

            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <button type="button" class="btn btn-primary d-block mx-auto" disabled>Medium</button>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-body">
          <h5 class="card-title">Special title treatment</h5>
            <img src="https://cdn2.iconfinder.com/data/icons/vehicles-5/100/721793-_Trucks-512.png" class="d-block w-25" alt="EXIST" >

            <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
            <button type="button" class="btn btn-primary d-block mx-auto" disabled> Heavy </button>
        </div>
      </div>
    </div>
  </div>
  <a href="/view/logout.jsp">LOGOUT</a>
  <div class="d-flex justify-content-center">
              <div class="card  shadow-lg p-3 mb-5 bg-body rounded" style="width: 18rem;">
                  <div class="card-body" id="calculator">
                      <form action="/calculator" method="post">
                          <h1 class="h3 mb-3 fw-normal">  <fmt:message key="calculator.title" /><br>
                          </h1>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input type="text" name="fromCity" class="form-control" placeholder="<fmt:message key="calculator.from.city" />" required/>
                              </div>
                          </div>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input type="text" name="toCity" class="form-control" placeholder="<fmt:message key="calculator.to.city" />" required/>
                              </div>
                          </div>
                          <p>  <fmt:message key="calculator.select" /></p>
                          <select class="form-control" name="weight">
                              <option value="1"><fmt:message key="calculator.select.light" /></option>
                              <option value="2"><fmt:message key="calculator.select.medium" /></option>
                              <option value="3"><fmt:message key="calculator.select.heavy" /></option>
                          </select>
                          <p> <fmt:message key="calculator.select.date" /></p>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input class="form-control" type="date" name="calendar" min="${date}">
                              </div>
                          </div>
                          <button type="submit" class="btn btn-primary btn-lg btn-lg d-block mx-auto"><fmt:message key="calculator.button" /></button>
                      </form>

                  </div>
              </div>
              <div class="card w-80 shadow-lg p-3 mb-5 bg-body rounded">
                  <div class="card-body">
                      <h5 class="card-title">Special title treatment</h5>

                      <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                  </div>
              </div>
          </div>
      </div>
  </div>

  <div class="card shadow-lg p-3 mb-5 bg-body rounded">
      <form action="/filterSelct" method="get">
          <h2 class="container text-center"><fmt:message key="top.tittle"/><img src="https://img.icons8.com/doodle/48/000000/fire-element--v1.png"/>
          </h2>
          <div class="form-group row">
              <select class="form-control" name="topSelect">
                  <option value="1"><fmt:message key="top.select.way"/> </option>
                  <option value="2"><fmt:message key="top.select.time"/></option>
                  <option value="3"><fmt:message key="top.select.price"/></option>
              </select>
          </div>
          <table class="table table-hover">
              <thead>
              <tr class="table-info">
                  <th scope="col"><fmt:message key="top.table.fromCity"/></th>
                  <th scope="col"><fmt:message key="top.table.toCity"/></th>
                  <th scope="col"><fmt:message key="top.table.time"/></th>
                  <th scope="col"><fmt:message key="top.table.way"/></th>
                  <th scope="col"><fmt:message key="top.table.tariff"/></th>
                  <th scope="col"><fmt:message key="top.table.price"/></th>
              </tr>
              </thead>
              <tbody>
              <c:forEach var="order" items="${orderList}">
                  <tr>
                      <td>${order.fromCity}</td>
                      <td>${order.toCity}</td>
                      <td>${order.time.hour} h ${order.time.minute} m</td>
                      <td>${order.distance}</td>
                      <td>${order.baggageWeight}</td>
                      <td>${order.cost}</td>
                  </tr>
              </c:forEach>
              </tbody>
          </table>
          <button type="submit" class="btn btn-primary btn-lg d-block mx-auto"><fmt:message key="top.button"/></button>
      </form>
  </div>

  <%@include file="view/blocks/footer.jsp"%>

  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>
  </body>
</html>
