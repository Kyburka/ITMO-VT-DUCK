def parse_yml(text):
    lines = text.split('\n')
    current_path = []
    res = {}

    for line in lines:
        if not line.strip() or line.strip() == '#':
            continue
        level = 0
        for char in line:
            if char == '\t':
                level += 1
            else:
                break    
        content = line[level:]
        if ':' in content:
            key,value = content.split(':', 1)
            key = key.strip()
            value = value.strip()
            while len(current_path) > level:
                current_path.pop()
            current_dict = res
            for key_in_path in current_path:
                if key_in_path not in current_dict:
                    current_dict[key_in_path] = {}
                current_dict = current_dict[key_in_path]
            if value:
                current_dict[key] = parse_value(value)
            else:
                current_dict[key] = {}
            current_path.append(key)
            if value:
                current_path.pop()
    return res

def parse_value(value):
    if value[0] == '[' and value[-1] == ']':
        content = value[1:-1].strip()
        if not content:
            return []
        else:
            items = [item.strip() for item in content.split(',')]
            return [parse_value(item) for item in items]
    elif (value[0] == '"' and value[-1] == '"') or (value[0] == "'" and value[-1] == "'"):
        content = value[1:-1].strip()
        if not content:
            return ""
        else:
            return value[1:-1]
    elif not value:
        return ""
    elif value.strip().isdigit():
        return int(value.strip())
    elif value.lower().strip() == "true":
        return True
    elif value.lower().strip() == "false":
            return False
    else:
        return value
    
s = """
name: "Test"
    age: 25
        gender: True
"""
print(parse_yml(s)) 