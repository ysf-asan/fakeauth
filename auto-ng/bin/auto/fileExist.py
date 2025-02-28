import os

exist = False

def find_folder(folder_name, search_path):
    found_paths = []

    if not os.path.exists(search_path):
        return []

    for root, dirs, _ in os.walk(search_path):
        if folder_name in dirs:
            found_paths.append(os.path.join(root,folder_name))

            return found_paths

if os.name == "nt":
    search_dirs = ["C:\\" , "D:\\", "E:\\"]
else:
    search_dirs = ["/"]

folder_to_find = "aircrack-ng-1.7-win"

results = []

for search_dir in search_dirs:
    found_folders = find_folder(folder_to_find, search_dir)
    if found_folders:
        results.extend(found_folders)

if results:
    print("Bulunan Klasörler: ")
    for path in results:
        print(path)
    exist = True
    print(exist)
else:
    print("Bulunamadı")
    print(exist)