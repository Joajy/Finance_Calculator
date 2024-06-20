<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<head>
  <title>Calculate Deposit</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      display: flex;
    }
    #sidebar {
      width: 250px;
    }
    @media (max-width: 768px) {
      #sidebar {
        display: none;
      }
    }
  </style>
</head>
<body>
<div id="sidebar" class="bg-light p-3">
  <h3>Menu</h3>
  <ul class="nav flex-column">
    <li class="nav-item">
      <a class="nav-link active" href="/deposit">Deposit</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/saving">Saving</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/loan">Loan</a>
    </li>
    <li class="nav-item">
      <a class="nav-link active" href="/exchange">Exchange Rate</a>
    </li>
  </ul>
</div>
<div class="container-fluid p-3">
  <h1>Calculate Deposit</h1>
  <h2>적금: 목돈을 만들기 위해 일정 기간 동안 정해진 금액을 납입하는 방식입니다.</h2>
  <form id="depositForm">
    <div class="mb-3">
      <label for="amount" class="form-label">Monthly Amount</label>
      <input type="text" class="form-control" id="amount" name="amount">
    </div>
    <div class="mb-3">
      <label for="interestRate" class="form-label">Annual Interest Rate (%)</label>
      <input type="text" class="form-control" id="interestRate" name="interestRate">
    </div>
    <div class="mb-3">
      <label for="year" class="form-label">Number of Years</label>
      <input type="text" class="form-control" id="year" name="year">
    </div>
    <div class="mb-3">
      <label for="interestType" class="form-label">Interest Type</label>
      <select class="form-select" id="interestType" name="interestType">
        <option value="simple">Simple Interest</option>
        <option value="yearCompound">Compound Interest</option>
        <option value="sixMonthCompound">6 Months Compound Interest</option>
        <option value="threeMonthCompound">3 Months Compound Interest</option>
        <option value="everyMonthCompound">Monthly Compound Interest</option>
      </select>
    </div>
    <div class="mb-3">
      <label for="interestIncome" class="form-label">Interest Income</label>
      <select class="form-select" id="interestIncome" name="interestIncome">
        <%--  일반 과세, 세금 우대   --%>
        <option value="normal">General Taxation</option>
        <option value="preferential">Tax Break</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Calculate</button>
  </form>
  <div id="beforeResult" class="mt-3">
    <!-- Calculation result will be displayed here -->
    <p></p>
  </div>
  <div id="afterResult" class="mt-3">
    <!-- Calculation result will be displayed here -->
    <p></p>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    $('#depositForm').on('submit', function(event) {
      event.preventDefault();
      const formData = {
        amount: $('#amount').val(),
        interestRate: $('#interestRate').val(),
        year: $('#year').val(),
        interestType: $('#interestType').val(),
        interestIncome: $('#interestIncome').val()
      };
      $.ajax({
        type: 'POST',
        url: '/deposit/calculate/before',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(result) {
          $('#beforeResult').html('<p>Before Amount: ' + result + '</p>');
        },
        error: function(error) {
          $('#beforeResult').html('<p>An error occurred</p>');
        }
      });
      $.ajax({
        type: 'POST',
        url: '/deposit/calculate/after',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(result) {
          $('#afterResult').html('<p>After Amount: ' + result + '</p>');
        },
        error: function(error) {
          $('#afterResult').html('<p>An error occurred</p>');
        }
      });
    });
  });
</script>
</body>
