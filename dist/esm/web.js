import { WebPlugin } from '@capacitor/core';
export class LocalStorageMigratorWeb extends WebPlugin {
    async read({ key }) {
        return { value: localStorage.getItem(key) };
    }
}
//# sourceMappingURL=web.js.map