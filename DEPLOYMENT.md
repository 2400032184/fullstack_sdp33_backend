# Backend Deployment Guide

## Prerequisites
- Java 17 or higher
- Maven installed
- MySQL database (already set up)
- Git

## Before Deploying

### 1. **Never commit sensitive data**
- Database credentials are now in `.env` file (NOT committed)
- Use environment variables for all sensitive configuration
- Keep `.env` file in `.gitignore`

### 2. **Set Up Environment Variables on Your Server**

Create a `.env` file with your production database details:
```bash
DB_URL=jdbc:mysql://your-mysql-host:3306/feedback_db
DB_USERNAME=your_db_user
DB_PASSWORD=your_secure_password
SERVER_PORT=8080
ALLOWED_ORIGINS=https://your-frontend-domain.com
```

### 3. **Build the Application**

```bash
# Clean and build
mvn clean package

# This creates: target/backend-0.0.1-SNAPSHOT.jar
```

### 4. **Local Testing Before Deployment**

```bash
# Test with environment variables
export DB_URL=jdbc:mysql://localhost:3306/feedback_db
export DB_USERNAME=root
export DB_PASSWORD=Srij@207
java -jar target/backend-0.0.1-SNAPSHOT.jar
```

### 5. **Deploy to Server (Heroku Example)**

```bash
# Install Heroku CLI
# Login to Heroku
heroku login

# Create new app
heroku create your-app-name

# Set environment variables on Heroku
heroku config:set DB_URL=jdbc:mysql://your-mysql-host:3306/feedback_db
heroku config:set DB_USERNAME=your_db_username
heroku config:set DB_PASSWORD=your_db_password
heroku config:set ALLOWED_ORIGINS=https://your-frontend-domain.com

# Deploy
git push heroku main
```

### 6. **Common Deployment Platforms**

#### **AWS EC2**
```bash
# SSH into your instance
ssh -i your-key.pem ubuntu@your-server-ip

# Set environment variables
export DB_URL=...
export DB_USERNAME=...
export DB_PASSWORD=...
export ALLOWED_ORIGINS=...

# Run the JAR
java -jar backend-0.0.1-SNAPSHOT.jar
```

#### **DigitalOcean / Linode**
- Same as AWS EC2
- Use their managed MySQL database service

#### **Railway / Render**
- Upload the JAR file
- Set environment variables in the dashboard
- Platform auto-starts the application

## After Backend Deployment

1. **Get Your Backend URL** (e.g., `https://your-app-name.herokuapp.com`)
2. **Update Frontend Components**

In your React components, replace localhost with deployed URL:

```javascript
// OLD (localhost)
const API_URL = "http://localhost:8080";

// NEW (deployed)
const API_URL = "https://your-app-name.herokuapp.com";
```

### Example API Call Update:
```javascript
// In your API service file
const API_BASE_URL = process.env.REACT_APP_API_URL || "http://localhost:8080";

// Or use environment variable in .env
REACT_APP_API_URL=https://your-backend-url.com
```

3. **Deploy Frontend** with the new backend URL

## Troubleshooting

### ❌ Database Connection Error
- Verify `DB_URL` is accessible from server
- Check database credentials
- Ensure MySQL server allows connections from your provider

### ❌ CORS Error
- The backend now accepts `ALLOWED_ORIGINS` environment variable
- Make sure to set it to your frontend domain

### ❌ Port Already in Use
- Change `SERVER_PORT` environment variable
- Or kill the process using port 8080

## Security Checklist

- ✅ Credentials moved to environment variables
- ✅ CORS configured for production domain
- ✅ No sensitive data in git repository
- ✅ Database encrypted password (if supported by your MySQL provider)
- ✅ Use HTTPS for all communications

## Next Steps

1. Update your `.gitignore` to include `.env` file
2. Generate your JAR file locally
3. Upload to your deployment platform
4. Set environment variables
5. Update frontend with backend URL
6. Deploy frontend
