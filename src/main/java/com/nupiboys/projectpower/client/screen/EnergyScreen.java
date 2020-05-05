package com.nupiboys.projectpower.client.screen;

import com.google.common.collect.Lists;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Slot;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;
import com.nupiboys.projectpower.ProjectPower;
import com.nupiboys.projectpower.blocks.TileBase;
import com.nupiboys.projectpower.client.screen.widget.IconButton;
import com.nupiboys.projectpower.client.util.Draw;
import com.nupiboys.projectpower.energy.Energy;
import com.nupiboys.projectpower.energy.SideConfig;
import com.nupiboys.projectpower.inventory.EnergyContainerBase;
import com.nupiboys.projectpower.inventory.slot.SlotBase;
import com.nupiboys.projectpower.network.packet.SNextEnergyConfigPacket;
import com.nupiboys.projectpower.network.packet.SNextRedstoneModePacket;

import java.util.ArrayList;
import java.util.List;

@OnlyIn(Dist.CLIENT)
public class EnergyScreen<T extends TileBase.EnergyStorage, C extends EnergyContainerBase<T>> extends TileContainerScreen<T, C> {
    private static final ResourceLocation GUI_TEXTURE = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/energy.png");
    private static final ResourceLocation GUI_MACHINE = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/energy_blank.png");
    private static final ResourceLocation GUI_WIDGET = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/widget.png");
    public static final ResourceLocation GUI_BUFFER = new ResourceLocation(ProjectPower.MOD_ID, "textures/gui/container/buffer.png");
    protected IconButton[] configButtons = new IconButton[6];
    protected IconButton configButtonAll = ICON_BUTTON;
    protected IconButton showConfigButton = ICON_BUTTON;
    protected IconButton redStoneButton = ICON_BUTTON;
    protected boolean configVisible;

    public EnergyScreen(C container, PlayerInventory playerInventory, ITextComponent name) {
        super(container, playerInventory, name);
        this.xSize = 195;
        this.ySize = 164;
    }

    @Override
    protected void init() {
        super.init();
        boolean b = showConfigButton();
        mainButtons(this.x, this.y + (b ? 0 : -14));
        configButtons(this.x, this.y);
        this.showConfigButton.visible = b;
    }

    protected boolean showConfigButton() {
        return true;
    }

    protected void mainButtons(int x, int y) {
        this.showConfigButton = addIconButton(x + this.xSize - 18, y + 13, 15, 15, 15, 0, 15, getWidgetTexture(), (button) -> {
            this.configVisible = !this.configVisible;
        }).tooltip("info.projectpower.configuration", TextFormatting.GRAY);
        this.redStoneButton = addIconButton(x + this.xSize - 18, y + 29, 15, 15, 30, 0, 15, getWidgetTexture(), (button) -> {
            SNextRedstoneModePacket.send(this.te.getPos());
            this.te.nextRedstoneMode();
        }).tooltip(this.te.getRedstoneMode().getDisplayName());
    }

    protected void configButtons(int x, int y) {
        this.configButtonAll = addIconButton(x + 151, y + 11, 15, 15, 30, 0, 15, getWidgetTexture(), (button) -> {
            SNextEnergyConfigPacket.send(6, this.te.getPos());
            this.te.getSideConfig().nextTypeAllSides();
        }).tooltip("info.projectpower.side.all", TextFormatting.GRAY, TextFormatting.DARK_GRAY).tooltip(this.te.getSideConfig().getType(Direction.UP).getDisplayName());
        for (int i = 0; i < 6; i++) {
            int xOffset = getSideButtonOffsets(18).get(i).getLeft();
            int yOffset = getSideButtonOffsets(18).get(i).getRight();
            final Direction side = Direction.byIndex(i);
            this.configButtons[i] = addIconButton(x + 132 + xOffset, y + 28 + yOffset, 17, 17, 0, 30, 17, getWidgetTexture(), (button) -> {
                SNextEnergyConfigPacket.send(side.getIndex(), this.te.getPos());
                this.te.getSideConfig().nextType(side);
            }).tooltip("info.projectpower.side." + side.getName(), TextFormatting.GRAY, TextFormatting.DARK_GRAY).tooltip(this.te.getSideConfig().getType(side).getDisplayName());
        }
    }

    private List<Pair<Integer, Integer>> getSideButtonOffsets(int spacing) {
        List<Pair<Integer, Integer>> pairs = Lists.newArrayList(
                Pair.of(0, spacing), Pair.of(0, -spacing), Pair.of(0, 0),
                Pair.of(spacing, spacing), Pair.of(-spacing, 0), Pair.of(spacing, 0)
        );
        return pairs;
    }

    @Override
    protected void refreshScreen() {
        this.configButtonAll.visible = this.configVisible;
        SideConfig config = this.te.getSideConfig();
        for (int i = 0; i < this.configButtons.length; i++) {
            this.configButtons[i].visible = this.configVisible;
            this.configButtons[i].setIconDiff(this.te.getSideConfig().getType(Direction.byIndex(i)).getXuv());
            if (this.configVisible && this.configButtons[i].isHovered()) {
                List<String> list = this.configButtons[i].getTooltip();
                list.add(config.getType(Direction.byIndex(i)).getDisplayName());
                list.remove(1);
            }
        }
        this.redStoneButton.setIconDiff(this.te.getRedstoneMode().getXuv());
        if (this.redStoneButton.isHovered()) {
            List<String> list = this.redStoneButton.getTooltip();
            list.add(this.te.getRedstoneMode().getDisplayName());
            list.remove(0);
        }
        if (this.configVisible) {
            if (this.configButtonAll.isHovered()) {
                List<String> list = this.configButtonAll.getTooltip();
                if (!config.isAllSame()) {
                    if (list.size() == 2) {
                        list.remove(1);
                    }
                } else {
                    String s = config.getType(Direction.byIndex(0)).getDisplayName();
                    if (list.size() == 1) {
                        list.add(s);
                    } else {
                        list.add(s);
                        list.remove(1);
                    }
                }
            }
        }
    }

    @Override
    protected void drawForeground(int mouseX, int mouseY) {
        String s = this.title.getFormattedText();
        int sw = this.font.getStringWidth(s);
        this.font.drawStringWithShadow(s, -(sw / 2) + (this.xSize / 2), -14.0F, 0x777777);

    }

    @Override
    protected void drawBackground(float partialTicks, int mouseX, int mouseY) {
        super.drawBackground(partialTicks, mouseX, mouseY);
        if (this.configVisible) {
            bindTexture(getConfigBackGround());
        } else {
            bindTexture(getMachineBackGround());
        }
        blit(this.x + 15, this.y, 15, 0, 161, 72);

        drawEnergyGauge(0, 0, this.te.getEnergyStorage());
    }

    protected void drawEnergyGauge(int x, int y, Energy energy) {
        if (energy.getCapacity() > 0) {
            bindTexture(getBackGround());
            Draw.gaugeV(this.x + 4, this.y + 4, 10, 64, 0, 164, energy);
        }
    }

    @Override
    protected boolean hideSlot(Slot slot) {
        return slot instanceof SlotBase && this.configVisible || super.hideSlot(slot);
    }

    @Override
    protected void renderHoveredToolTip(int mouseX, int mouseY) {
        List<String> list = new ArrayList<>();
        this.te.getListedEnergyInfo(list);
        if (!list.isEmpty() && isMouseOver(mouseX - 3, mouseY - 3, 12, 66)) {
            renderTooltip(list, mouseX, mouseY);
        }
        super.renderHoveredToolTip(mouseX, mouseY);
    }

    protected ResourceLocation getMachineBackGround() {
        return GUI_MACHINE;
    }

    protected ResourceLocation getConfigBackGround() {
        return GUI_MACHINE;
    }

    protected ResourceLocation getWidgetTexture() {
        return GUI_WIDGET;
    }

    @Override
    protected ResourceLocation getBackGround() {
        return GUI_TEXTURE;
    }
}
