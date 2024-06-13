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
  </ul>
</div>
<div class="container-fluid p-3">
  <h1>Calculate Loan</h1>
  <h2>대출: 필요에 의해 금융권으로부터 돈이나 물건 등을 빌리는 방식입니다.</h2>
  <form id="loanForm">
    <div class="mb-3">
      <label for="amount" class="form-label">Principal Amount</label>
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
      <label for="loanType" class="form-label">Loan Type</label>
      <select class="form-select" id="loanType" name="loanType">
        <%-- 원리금균등분할상환 --%>
        <option value="eia">Equal Installment Amortization</option>
        <%-- 원금균등분할상환 --%>
        <option value="epa">Equal Principal Amortization</option>
        <%-- 만기일시상환 --%>
        <option value="bullet">Bullet Repayment</option>
      </select>
    </div>
    <button type="submit" class="btn btn-primary">Calculate</button>
  </form>
  <div id="result" class="mt-3">
    <!-- Calculation result will be displayed here -->
    <p></p>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
  $(document).ready(function() {
    $('#loanForm').on('submit', function(event) {
      event.preventDefault();
      const formData = {
        amount: $('#amount').val(),
        interestRate: $('#interestRate').val(),
        year: $('#year').val(),
        loanType: $('#loanType').val(),
      };
      $.ajax({
        type: 'POST',
        url: '/loan/calculate',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(result) {
            if(formData.loanType === 'bullet'){
                $('#result').html('<p>Monthly Paid Result: ' + result + '</p>'
                + '<p> Last Month Paid Principal: ' + formData.amount + '</p>');
            } else {
                $('#result').html('<p>Monthly Paid Result: ' + result + '</p>');
            }
        },
        error: function(error) {
          $('#result').html('<p>An error occurred</p>');
        }
      });
    });
  });
</script>
</body>
