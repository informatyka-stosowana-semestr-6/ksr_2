import os
import pandas as pd
#
#
# def get_data_path():
#     path_to_csv = os.path.dirname(os.path.dirname(__file__))
#     path_to_csv = os.path.join(path_to_csv, "data", "csv", "all_perth_310121.csv")
#     return path_to_csv
#
#
# def get_headers(df):
#     print(len(df.columns))
#     for column in df.columns:
#         print(column, df[column][0])
#
#
# def get_min_max(df, column_name):
#     print(min(df[column_name]), max(df[column_name]))
#
#
# if __name__ == '__main__':
#     df = pd.read_csv(get_data_path())
#
#     get_headers(df)
#     get_min_max(df, "NEAREST_SCH_DIST")


def check_data_size():
    # 51707 jest łącznie
    folder_objects = os.listdir("D:\studia\semestr_8\KSR\ksr_2\python_for_documentation_check\data")
    number_of_records = 0
    for file in folder_objects:
        df = pd.read_csv(os.path.join("D:\studia\semestr_8\KSR\ksr_2\python_for_documentation_check\data", file))
        number_of_records += len(df)
    return number_of_records

if __name__ == '__main__':
    print(check_data_size())
    #