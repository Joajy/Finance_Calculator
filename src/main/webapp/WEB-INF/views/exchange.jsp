<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
    <title>Exchange Rate Calculator</title>
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
    <h1>Exchange Rate Calculator</h1>
    <form id="exchangeRateForm">
        <div class="mb-3">
            <label for="amount" class="form-label">Amount</label>
            <input type="text" class="form-control" id="amount" name="amount">
        </div>
        <div class="mb-3">
            <label for="currencies" class="form-label">Currency</label>
            <select class="form-select" id="currencies" name="currencies">
                <option value='AED' title='United Arab Emirates Dirham'>AED</option>
                <option value='AUD' title='Australian Dollar'>AUD</option>
                <option value='BHD' title='Bahrain Dinar'>BHD</option>
               <option value='BND' title='Brunei Dollar'>BND</option>
                <option value='CAD' title='Canadian Dollar'>CAD</option>
                <option value='CHF' title='Swiss Franc'>CHF</option>
                <option value='CNH' title='Chinese Yuan'>CNH</option>
                <option value='DKK' title='Danish Krone'>DKK</option>
                <option value='EUR' title='Euro'>EUR</option>
                <option value='GBP' title='British Pound Sterling'>GBP</option>
                <option value='HKD' title='Hong Kong Dollar'>HKD</option>
                <option value='IDR(100)' title='Indonesian Rupiah'>IDR</option>
                <option value='JPY(100)' title='Japanese Yen'>JPY</option>
                <option value='KRW' title='South Korean Won'>KRW</option>
                <option value='KWD' title='Kuwaiti Dinar'>KWD</option>
                <option value='MYR' title='Malaysia Ringgit'>MYR</option>
                <option value='NOK' title='Norwegian Krone'>NOK</option>
                <option value='NZD' title='New Zealand Dollar'>NZD</option>
                <option value='SAR' title='Saudi Riyal'>SAR</option>
                <option value='SEK' title='Swedish Krona'>SEK</option>
                <option value='SGD' title='Singapore Dollar'>SGD</option>
                <option value='THB' title='Thai Baht'>THB</option>
                <option value='USD' title='United States Dollar'>USD</option>
            </select>
        </div>
        <button type="submit" class="btn btn-primary">Get Exchange Rate</button>
    </form>
    <div id="exchangeRateResult" class="mt-3">
        <!-- Exchange rate result will be displayed here -->
        <p></p>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        $('#exchangeRateForm').on('submit', function(event) {
            event.preventDefault();
            const formData = {
                amount: $('#amount').val(),
                currencies: $('#currencies').val()
            };
            $.ajax({
                type: 'POST',
                url: '/exchange/getExchangeRate',
                contentType: 'application/json',
                data: JSON.stringify(formData),
                success: function(result) {
                    $('#exchangeRateResult').html('<p>Exchange Rate(Remove Decimal Point): ' + result + '</p>');
                },
                error: function(error) {
                    $('#exchangeRateResult').html('<p>An error occurred</p>');
                }
            });
        });
    });
</script>
</body>
</html>
