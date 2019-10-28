from MontariaInterface import MontariaInterface
from VendedorInterface import VendedorInterface

vendedores = []
montarias = []

while True:

    print("\n╔════════ MENU ════════╗")
    try:
        op = int(input("╠0 Fechar programa\n╠1 Menu Vendedor\n╚2 Menu Montaria\n⟶ "))
    except ValueError:
        continue
    if op == 0:
        break
    elif op == 1:
        VendedorInterface.menu(vendedores, montarias)

    elif op == 2:
        MontariaInterface.menu(montarias)

    else:
        print("\nNão há esta opção, por favor digite novamente.")
