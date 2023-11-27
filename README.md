# blerify-stream-trades

## Stak
- Java 17
- Graddle 8.4
- Spring Boot 3.2

## How to test the websocket
1. Open the trades.html inside the your default browser.
    - PATH: src/main/resources/templates/trades.html
2. Click over "connect button"
3. Send payload:

```
{
  "e": "trade",
  "E": 123456789,
  "s": "BNBBTC",
  "t": 12345,
  "p": "0.001",
  "q": "100",
  "b": 88,
  "a": 50,
  "T": 123456785,
  "m": true,
  "M": true
}
```

## Discuss

- How would you keep a system running once a database starts rejecting new connections?
- What are the risks of using containers?
- Is it possible to deploy any component on Kubernetes? What components are not recommended
to deploy on Kubernetes?
- When would you use java and when golang?