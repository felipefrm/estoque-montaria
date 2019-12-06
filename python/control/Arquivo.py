class Arquivo:
    __instance = None
    def getInstance():
     if Singleton.__instance == None:
        Singleton()
     return Arquivo.__instance
     def __init__(self):
     if Singleton.__instance != None:
        raise Exception()
     else:
        Singleton.__instance = self

    def abreArquivoMontaria(self,fname_mont,montarias):
        max_id = 1
        try:
            with open(fname_mont, 'r') as fvend:
                list_dict=json.load(fvend)
                for obj in list_dict:
                    max_id=max(max_id,obj['id']+1)
                    montarias.append(Montaria(obj['raca'], obj['descricao'], obj['combustivel'],
                    obj['raridade'], obj['capacidade'], obj['velocidade']))
                    montarias[-1].setId(obj['id'])
            Montaria.setCont(max_id)
        except Exception as e:
        return

    def abreArquivoMontaria(self,fname_vend,vendedores):
        max_id=1
        try:
            with open(fname_vend, 'r') as fvend:
                list_dict=json.load(fvend)
                for obj in list_dict:
                    max_id=max(max_id,obj['id']+1)
                    vendedores.append(Vendedor(obj['nome'], obj['raca'], obj['idade'], obj['descricao']))
                    vendedores[-1].setId(obj['id'])
                    estoque=list()
                    for i in obj['estoque']:
                        montid=i['montaria']['id']
                        for m in montarias:
                            if m.getId() == montid:
                                estoque.append(Estoque(i['quantidade'],i['preco'],m))
                                break
                    vendedores[-1].setEstoque(estoque)
            Vendedor.setCont(max_id)
        except Exception as e:
        return

    def salvaArquivo(self,pathVendedor,pathMontaria,vendedores,montarias):
        if vendedores == None:
