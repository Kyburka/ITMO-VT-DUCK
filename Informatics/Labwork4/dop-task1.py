with open('Task1_Binary.bin', 'rb') as bin_file:
    binary_data = bin_file.read()

def DeserializeFromBin(binary_data):
    def deserialize(data, offset):
        if offset >= len(data):
            return None, offset

        # определяем тип данных по первому байту
        type_byte = data[offset:offset + 1]
        offset += 1

        if type_byte == b'D':  # Словарь
            count = int.from_bytes(data[offset:offset + 2], 'big')
            offset += 2
            
            result = {}
            for _ in range(count):
                key_length = int.from_bytes(data[offset:offset + 2], 'big')
                offset += 2
                key = data[offset:offset + key_length].decode('utf-8')
                offset += key_length
                
                value, offset = deserialize(data, offset)
                result[key] = value
            return result, offset

        elif type_byte == b'L':  # Список
            length = int.from_bytes(data[offset:offset + 2], 'big')
            offset += 2
            result = []
            for _ in range(length):
                item, offset = deserialize(data, offset)
                result.append(item)
            return result, offset

        elif type_byte == b'S':  # Строка
            length = int.from_bytes(data[offset:offset + 2], 'big')
            offset += 2
            value = data[offset:offset + length].decode('utf-8')
            offset += length
            return value, offset
        
        # Если пришел неизвестный байт или мусор — возвращаем None и текущий сдвиг, чтобы не упасть
        return None, offset

    result, _ = deserialize(binary_data, 0)
    return result

# так как INI плоский, вложенность делаем через точки в названиях секций
def ToIni(data):
    lines = []

    def _traverse(current_data, section_stack):
        prefix = ".".join(section_stack)
        
        if isinstance(current_data, dict):
            scalars = {}
            complex_items = {}
            
            # разделяем простые значения и вложенные структуры
            for k, v in current_data.items():
                if isinstance(v, (dict, list)):
                    complex_items[k] = v
                else:
                    scalars[k] = v
            
            if prefix and (scalars or complex_items):
                 lines.append(f"\n[{prefix}]")

            for k, v in scalars.items():
                lines.append(f"{k} = {v}")
            
            # рекурсивно спускаемся глубже
            for k, v in complex_items.items():
                new_stack = section_stack + [k]
                _traverse(v, new_stack)

        elif isinstance(current_data, list):
            for index, item in enumerate(current_data):
                # для списков добавляем индекс в название секции
                new_stack = list(section_stack)
                if new_stack:
                    new_stack[-1] = f"{new_stack[-1]}.{index}"
                else:
                    new_stack = [str(index)]
                
                _traverse(item, new_stack)

    # запускаем обход дерева данных
    if isinstance(data, dict):
        _traverse(data, [])
    elif isinstance(data, list):
        for i, item in enumerate(data):
            _traverse(item, [str(i)])

    return "\n".join(lines).strip()

if __name__ == '__main__':
    data = DeserializeFromBin(binary_data)
    ini_text = ToIni(data)
    with open("Dop_Task1.ini", "w", encoding="utf-8") as f:
        f.write(ini_text)