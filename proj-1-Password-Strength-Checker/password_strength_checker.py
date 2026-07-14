def check_password_strength(password):
    has_upper = False
    has_lower = False
    has_digit = False
    has_symbol = False

    symbols = "!@#$%^&*()-_=+[]{}|\\;:'\",.<>?/`~"

    for char in password:
        if char.isupper():
            has_upper = True
        elif char.islower():
            has_lower = True
        elif char.isdigit():
            has_digit = True
        elif char in symbols:
            has_symbol = True

    score = 0

    if len(password) >= 8:
        score += 1
    if has_upper:
        score += 1
    if has_lower:
        score += 1
    if has_digit:
        score += 1
    if has_symbol:
        score += 1

    if score <= 2:
        strength = "Weak"
    elif score <= 4:
        strength = "Medium"
    else:
        strength = "Strong"

    return {
        "Length": len(password),
        "Uppercase": has_upper,
        "Lowercase": has_lower,
        "Numbers": has_digit,
        "Symbols": has_symbol,
        "Strength": strength
    }

print("=" * 40)
print("PASSWORD STRENGTH CHECKER")
print("=" * 40)

password = input("Enter Password: ")

result = check_password_strength(password)

print("\nPassword Analysis")
print("-" * 40)
print(f"Length      : {result['Length']}")
print(f"Uppercase   : {result['Uppercase']}")
print(f"Lowercase   : {result['Lowercase']}")
print(f"Numbers     : {result['Numbers']}")
print(f"Symbols     : {result['Symbols']}")
print("-" * 40)
print(f"Password Strength: {result['Strength']}")