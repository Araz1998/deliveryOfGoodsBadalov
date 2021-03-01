<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.araz.entity.User" %>
<%@ taglib prefix="my"  uri="/WEB-INF/mytags.tld" %>
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
<%--      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
<%--      <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>--%>
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
      <script>

          $(document).ready(function(){
              $("#loadB").hide();
              $("#submit").click(function(){
                  $("#loadB").show()
                  $("#submit").hide();
              });
          });
      </script>

  </head>
  <body>
  <%@include file="view/blocks/header.jsp"%>

  <script>
      function checkParams() {
          var from = $('#from').val();
          var to = $('#to').val();
          var tariff = $('#tariff').val();
          var date = $('#date').val();

          if(from.length != 0 && to.length != 0 && tariff.length != 0 && date.length != 0) {
              $('#submit').removeAttr('disabled');
          } else {
              $('#submit').attr('disabled', 'disabled');
          }
      }
  </script>


  <style>
      .custom{
          width: 30%;
      }

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
        </div>
      </div>
      <div class="carousel-item">
        <img src="view/blocks/3.jpg" class="d-block w-100" alt="..." width="1100" height="500">
        <div class="carousel-caption d-none d-md-block">
        </div>
      </div>
      <div class="carousel-item">
        <img src="view/blocks/cars.jpg" class="d-block w-100" alt="..." width="930" height="500">
        <div class="carousel-caption d-none d-md-block">
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
          <img src="https://cdn2.iconfinder.com/data/icons/vehicle-type/1024/mini-suv-512.png" class="d-block w-25 d-block mx-auto " alt="EXIST" >

          <p class="card-text"><fmt:message key="tariff.lite.text" /> </p>
          <button type="button" class="btn btn-primary d-block mx-auto custom"> <fmt:message key="tariff.lite"/> </button>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-body">
            <img src="https://cdn2.iconfinder.com/data/icons/transportation-solid-7/64/transportation-vehicle-25-512.png" class="d-block w-25 d-block mx-auto" alt="EXIST" >

            <p class="card-text"><fmt:message key="tariff.medium.text"/> </p>
            <button type="button" class="btn btn-primary d-block mx-auto custom"><fmt:message key="tariff.medium"/> </button>
        </div>
      </div>
    </div>
    <div class="col-sm-4">
      <div class="card shadow-lg p-3 mb-5 bg-body rounded">
        <div class="card-body">
            <img src="https://cdn2.iconfinder.com/data/icons/vehicles-5/100/721793-_Trucks-512.png" class="d-block w-25 d-block mx-auto" alt="EXIST" >

            <p class="card-text"><fmt:message key="tariff.extra.text"/></p>
            <button type="button" class="btn btn-primary d-block mx-auto custom"><fmt:message key="tariff.extra"/></button>
        </div>
      </div>
    </div>
  </div>
  <div class="d-flex justify-content-center">
              <div class="card  shadow-lg p-3 mb-5 bg-body rounded" style="width: 18rem;">
                  <div class="card-body" id="calculator">
                      <form action="/calculator" method="post">
                          <h1 class="h3 mb-3 fw-normal">  <fmt:message key="calculator.title" /><br>
                          </h1>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input id="from" onkeyup="checkParams()" type="text" name="fromCity" class="form-control" list="datalist" placeholder="<fmt:message key="calculator.from.city" />" required/>
                              </div>
                          </div>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input id="to" onkeyup="checkParams()" type="text" name="toCity" class="form-control" list="datalist" placeholder="<fmt:message key="calculator.to.city" />" required/>
                              </div>
                          </div>
                          <p>  <fmt:message key="calculator.select" /></p>
                          <select id="tariff" onkeyup="checkParams()" class="form-control" name="weight" required>
                              <option value="1"><fmt:message key="calculator.select.light" /></option>
                              <option value="2"><fmt:message key="calculator.select.medium" /></option>
                              <option value="3"><fmt:message key="calculator.select.heavy" /></option>
                          </select>
                          <p> <fmt:message key="calculator.select.date" /></p>
                          <div class="form-group row">
                              <div class="col-sm-12">
                                  <input id="date" onkeyup="checkParams()" class="form-control" type="date" name="calendar" min="${date}" required>
                              </div>
                          </div>
                      <div class="fs-2 mb-3 col text-center">
                          <button id="submit" disabled type="submit" class="btn btn-primary btn-lg " data-toggle="modal" data-target="#basicModal">
                              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-calculator" viewBox="0 0 16 16">
                                  <path d="M12 1a1 1 0 0 1 1 1v12a1 1 0 0 1-1 1H4a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1h8zM4 0a2 2 0 0 0-2 2v12a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2a2 2 0 0 0-2-2H4z"/>
                                  <path d="M4 2.5a.5.5 0 0 1 .5-.5h7a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-7a.5.5 0 0 1-.5-.5v-2zm0 4a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm3-6a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v1a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-1zm0 3a.5.5 0 0 1 .5-.5h1a.5.5 0 0 1 .5.5v4a.5.5 0 0 1-.5.5h-1a.5.5 0 0 1-.5-.5v-4z"/>
                              </svg>
                              <fmt:message key="calculator.button"/>
                          </button>
                          <button id="loadB" class="btn btn-primary btn-lg">
                              <span class="spinner-border spinner-border-sm" role="status" aria-hidden="true"></span>
                              <span class="visually-hidden">Loading...</span>
                          </button>
                      </div>
                          <%if(request.getAttribute("Error") != null){%>
                          <script>
                              $("#loadB").hide();
                          </script>
                          <br>
                          <div class="alert alert-danger">
                              <span style="color: red">${Error}</span>
                          </div>
                          <%}%>
                      </form>

                  </div>
              </div>
              <div class="card w-50 shadow-lg p-3 mb-5 bg-body rounded">
                  <div class="card-body">
                      <p align="justify" class="card-text mb-50"><fmt:message key="text"/> </p>
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
              <select class="form-control" name="topSelect" onchange="this.form.submit();">
                  <option selected></option>
                  <option value="1"><fmt:message key="top.select.way"/></option>
                  <option value="2"><fmt:message key="top.select.time"/></option>
                  <option value="3"><fmt:message key="top.select.price"/></option>
              </select>
          </div>
          <table class="table table-hover">
              <thead>
              <tr class="table-info">
                  <th  scope="col"><fmt:message key="top.table.fromCity"/></th>
                  <th  scope="col"><fmt:message key="top.table.toCity"/></th>
                  <th  scope="col"><fmt:message key="top.table.time"/></th>
                  <th  scope="col"><fmt:message key="top.table.way"/></th>
                  <th  scope="col"><fmt:message key="top.table.tariff"/></th>
                  <th  scope="col"><fmt:message key="top.table.price"/></th>
                  <th  scope="col"><fmt:message key="top.table.date"/></th>
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
                      <td>${order.date}</td>
                  </tr>
              </c:forEach>
              </tbody>
          </table>
      </form>
  </div>

  <datalist id="datalist">
      <option value="Харьков">
      <option value="Kharkiv">
      <option value="Киев">
      <option value="Kiev">
      <option value="Львов">
      <option value="Lviv">
      <option value="Zhytomyr">
      <option value="Житомир">
      <option value="Купянск">
      <option value="Kupiansk">
      <option value="Полтава">
      <option value="Poltava">
  </datalist>

  <div class="modal fade" id="basicModal" tabindex="-1" role="dialog" aria-labelledby="basicModal" aria-hidden="true">
      <div class="modal-dialog">
          <div class="modal-content">
              <div class="modal-header">
                  <h4 class="modal-title" id="myModalLabel"><fmt:message key="modal.title"/></h4>
                  <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                      <span aria-hidden="true">×</span>
                  </button>
              </div>
              <div class="modal-body">
                  <h3><fmt:message key="modal.message"/></h3>
              </div>
          </div>
      </div>
  </div>
  <%@include file="view/blocks/footer.jsp"%>

  <%--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>--%>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>


  </body>
</html>
