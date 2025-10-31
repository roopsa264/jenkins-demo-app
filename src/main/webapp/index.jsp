<!DOCTYPE html>
<html>
<head>
    <title>Jenkins Demo App</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            text-align: center;
            padding: 50px;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
        }
        .container {
            background: white;
            color: #333;
            padding: 40px;
            border-radius: 10px;
            max-width: 600px;
            margin: 0 auto;
            box-shadow: 0 10px 30px rgba(0,0,0,0.3);
        }
        h1 { color: #667eea; }
        .success { color: #28a745; font-size: 24px; margin: 20px 0; }
    </style>
</head>
<body>
    <div class="container">
        <h1>🚀 Jenkins Pipeline Demo (Windows)</h1>
        <div class="success">✅ Deployment Successful!</div>
        <p>Your application has been successfully built and deployed through Jenkins CI/CD pipeline on Windows.</p>
        <hr>
        <h3>Pipeline Stages Completed:</h3>
        <ul style="text-align: left;">
            <li>✓ Git Checkout</li>
            <li>✓ Compile</li>
            <li>✓ Unit Tests</li>
            <li>✓ Build/Package</li>
            <li>✓ Deploy</li>
        </ul>
        <p><strong>Build Time:</strong> <%= new java.util.Date() %></p>
        <p><strong>Platform:</strong> Windows</p>
    </div>
</body>
</html>