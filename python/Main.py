import MontariaInterface
import VendedorInterface

vend = []
mont = []

while True:

    print("\n╔════════ MENU ════════╗")
    op = int(input("╠0 Fechar programa\n╠1 Menu Vendedor\n╠2 Menu Montaria\n⟶ "))

    if op == 0:
        return

    elif op == 1:
        VendedorInterface.menu(vend, mont)

    elif op == 2:
        MontariaInterface.menu(mont)

    else:
        print("\nNão há esta opção, por favor digite novamente.")