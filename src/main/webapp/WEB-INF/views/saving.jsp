<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
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
  <h1>Calculate Saving</h1>
  <form id="savingForm">
    <div class="mb-3">
      <label for="amount" class="form-label">Principal Amount</label>
      <input type="text" class="form-control" id="amount" name="amount">
    </div>
    <div class="mb-3">
      <label for="interestRate" class="form-label">Annual Interest Rate (%)</label>
      <input type="text" class="form-control" id="interestRate" name="interestRate">
    </div>
    <div class="mb-3">
      <label for="term" class="form-label">Number of Months</label>
      <input type="text" class="form-control" id="term" name="term">
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
    $('#savingForm').on('submit', function(event) {
      event.preventDefault();
      const formData = {
        amount: $('#amount').val(),
        interestRate: $('#interestRate').val(),
        term: $('#term').val()
      };
      $.ajax({
        type: 'POST',
        url: '/saving/calculate',
        contentType: 'application/json',
        data: JSON.stringify(formData),
        success: function(result) {
          $('#result').html('<p>Final Amount: ' + result + '</p>');
        },
        error: function(error) {
          $('#result').html('<p>An error occurred</p>');
        }
      });
    });
  });
</script>
</body>
</html>