# strongerpass-api

> ### Important Note
> It was not possible to entirely determine one of the Requirement rules (Repeat Characters (Case Insensitive)), hence it was not possible to accurately compute the bonus value for that specific Requirement. Given that, the bonus for it would always be zero (at least, for now) .

Based on the http://www.passwordmeter.com/ website, this api receives a string as a password, validates its strength, and returns the validation details to the caller.

### Executing:
Simply run ```StrongerpassApplication``` as a Java Application.

### Sample curl:
```
curl -X POST -H "Content-Type: application/json" -d '{
	"password":"lsakhdflkA$jhf"
}' "http://localhost:8080/password/check"
```

### Sample result:
```json
{
  "password": "[the_passwORd]",
  "score": 100,
  "strength": "VERY_STRONG",
  "lengthReq": {
    "count": 14,
    "bonus": 56,
    "status": "EXCEPTIONAL"
  },
  "uppercaseReq": {
    "count": 2,
    "bonus": 24,
    "status": "EXCEPTIONAL"
  },
  "lowercaseReq": {
    "count": 9,
    "bonus": 10,
    "status": "EXCEPTIONAL"
  },
  "numbersReq": {
    "count": 0,
    "bonus": 0,
    "status": "FAILURE"
  },
  "symbolsReq": {
    "count": 3,
    "bonus": 18,
    "status": "EXCEPTIONAL"
  },
  "midNumSymReq": {
    "count": 1,
    "bonus": 2,
    "status": "SUFFICIENT"
  },
  "lettersOnlyReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "numbersOnlyReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "repeatCharsReq": {
    "count": 1,
    "bonus": 0,
    "status": "WARNING"
  },
  "consecUppercaseReq": {
    "count": 1,
    "bonus": -2,
    "status": "WARNING"
  },
  "consecLowercaseReq": {
    "count": 6,
    "bonus": -12,
    "status": "WARNING"
  },
  "consecNumbersReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "seqLettersReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "seqNumbersReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "seqSymbolsReq": {
    "count": 0,
    "bonus": 0,
    "status": "SUFFICIENT"
  },
  "totalRequirementsReq": {
    "count": 4,
    "bonus": 8,
    "status": "SUFFICIENT"
  }
}
```
