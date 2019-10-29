from MontariaInterface import MontariaInterface
from VendedorInterface import VendedorInterface
from Montaria import Montaria
from Vendedor import Vendedor
import re
import json

vendedores = []
montarias = []
def getObjDict(obj):
    obj_dict=obj.__dict__
    for i in obj_dict.copy():
        name=re.split("__", i)[-1]
        obj_dict[name]=obj_dict.pop(i)
    return obj_dict
print("╔════════ Bases de dados ════════╗")
fname_vend=input("Nome do arquivo de vendedores ⟶ ")
max_id=1
list_dict=list()
try:
    with open(fname_vend, 'r') as fvend:
        list_dict=json.load(fvend)
        for obj in list_dict:
            max_id=max(max_id,obj['id']+1)
            vendedores.append(Vendedor(obj['nome'], obj['raca'], obj['idade'], obj['descricao']))
            vendedores[-1].setId(obj['id'])
            estoque=list()
            for i in obj['estoque']:
                estoque.append(Estoque(i['quantidade'],i['preco'],i['montaria']))
            vendedores[-1].setEstoque(estoque)
    Vendedor.setCont(max_id)
except Exception as e:
    print(e)
    print("Arquivo não encontrado. Usando base vazia.")
print(str(len(vendedores))+" vendedores carregados da base")

fname_mont=input("Nome do arquivo de montarias ⟶ ")
max_id=1
list_dict=list()
try:
    with open(fname_mont, 'r') as fvend:
        list_dict=json.load(fvend)
        for obj in list_dict:
            max_id=max(max_id,obj['id']+1)
            montarias.append(Montaria(obj['nome'], obj['raca'], obj['descricao'], obj['combustivel'], 
            obj['raridade'], obj['capacidade'], obj['velocidade']))
            montarias[-1].setId(obj['id'])
    Montaria.setCont(max_id)
except Exception as e:
    print(e)
    print("Arquivo não encontrado. Usando base vazia.")
print(str(len(montarias))+" montarias carregadas da base")


while True:
    # m=Montaria('eqwq', 'jov', 'topdemais', 2, 'ee', 5, 3)
    # montarias.append(m)
    # m=Montaria('21ewq', 'gsmfm', 'dscc', 10, 'w', 20, 50)
    # montarias.append(m)
    # m=Montaria('44', 'g432', 'ds11', 112, 'a', 4, 40)
    # montarias.append(m)
    
    # obj_dict=m.__dict__
    # for i in obj_dict.copy():
    #     name=re.split("__", i)[-1]
    #     obj_dict[name]=obj_dict.pop(i)
    # print(json.dumps(obj_dict))
    # break
    print("\n╔════════ MENU ════════╗")
    try:
        op = int(input("╠0 Fechar programa\n╠1 Menu Vendedor\n╚2 Menu Montaria\n⟶ "))
    except ValueError:
        continue
    if op == 0:
        list_dict=list()
        if vendedores:
            for v in vendedores:
                obj_dict=getObjDict(v)
                ests=list()
                for i in obj_dict['estoque']:
                    ests.append(getObjDict(i))
                    ests[-1]['montaria']=getObjDict(ests[-1]['montaria'])
                obj_dict['estoque']=ests
                list_dict.append(obj_dict)
               # print(obj_dict)
            with open(fname_vend, 'w') as outfile:
                json.dump(list_dict, outfile)
            # print(json.dumps(list_dict))
        list_dict=list()
        
        if montarias:
            for m in montarias:
                list_dict.append(getObjDict(m))
            with open(fname_mont, 'w') as outfile:
                json.dump(list_dict, outfile)
            #print(json.dumps(list_dict))
        break
    elif op == 1:
        VendedorInterface.menu(vendedores, montarias)

    elif op == 2:
        MontariaInterface.menu(montarias)

    else:
        print("\nNão há esta opção, por favor digite novamente.")
