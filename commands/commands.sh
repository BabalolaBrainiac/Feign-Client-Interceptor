# Get all posts
curl http://localhost:8080/api/posts

# Get a specific post
curl http://localhost:8080/api/posts/1

# Create a new post
curl -X POST http://localhost:8080/api/posts \
  -H "Content-Type: application/json" \
  -d '{"userId": 1, "title": "Test Post", "body": "This is a test post"}'